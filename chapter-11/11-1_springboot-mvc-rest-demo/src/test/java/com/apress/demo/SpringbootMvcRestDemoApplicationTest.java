package com.apress.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.apress.demo.entities.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootMvcRestDemoApplicationTest {
  @LocalServerPort
  private int port;

  RestTemplate restTemplate = new RestTemplate();

  private String getRootUrl() {
    return "http://localhost:" + port;
  }

  @Test
  public void testGetAllPosts() {
    ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(getRootUrl() + "/posts", Post[].class);
    List<Post> posts = Arrays.asList(responseEntity.getBody());
    assertNotNull(posts);
  }

  @Test
  public void testGetPostById() {
    Post post = restTemplate.getForObject(getRootUrl() + "/posts/1", Post.class);
    assertNotNull(post);
  }

  @Test
  public void testCreatePost() {
    Post post = new Post();
    post.setTitle("Exploring SpringBoot REST");
    post.setContent("SpringBoot is awesome!!");
    post.setCreatedOn(new Date());

    ResponseEntity<Post> postResponse = restTemplate.postForEntity(getRootUrl() + "/posts", post, Post.class);
    assertNotNull(postResponse);
    assertNotNull(postResponse.getBody());
  }

  @Test
  public void testUpdatePost() {
    int id = 1;
    Post post = restTemplate.getForObject(getRootUrl() + "/posts/" + id, Post.class);
    post.setContent("This my updated post1 content");
    post.setUpdatedOn(new Date());

    restTemplate.put(getRootUrl() + "/posts/" + id, post);

    Post updatedPost = restTemplate.getForObject(getRootUrl() + "/posts/" + id, Post.class);
    assertNotNull(updatedPost);
  }

  @Test
  public void testDeletePost() {
    int id = 2;
    Post post = restTemplate.getForObject(getRootUrl() + "/posts/" + id, Post.class);
    assertNotNull(post);

    restTemplate.delete(getRootUrl() + "/posts/" + id);

    try {
      post = restTemplate.getForObject(getRootUrl() + "/posts/" + id, Post.class);
    } catch (final HttpClientErrorException e) {
      assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
    }
  }
}
