package com.apress.demo.rest.endpoints;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.demo.entities.Post;
import com.apress.demo.rest.model.PostsRequestDTO;
import com.apress.demo.rest.model.PostsResponseDTO;
import com.apress.demo.services.BlogService;

@RestController
public class BlogRestController {
  private final static Logger LOGGER = LoggerFactory.getLogger(BlogRestController.class);

  @Autowired
  private BlogService blogService;

  @RequestMapping(value = "/api/posts", method = RequestMethod.GET)
  public PostsResponseDTO findPosts(PostsRequestDTO request) {
    Page<Post> pageData = blogService.findPosts(request);
    PostsResponseDTO postsResponse = new PostsResponseDTO(pageData);
    return postsResponse;
  }

  @RequestMapping(value = "/api/posts/{postId}", method = RequestMethod.GET)
  public Optional<Post> findPostById(@PathVariable(value = "postId") Integer postId) {
    LOGGER.debug("View Post id: " + postId);
    Optional<Post> post = blogService.findPostById(postId);
    return post;
  }

  @RequestMapping(value = "/api/admin/posts", method = RequestMethod.POST)
  public ResponseEntity<Post> createPost(@RequestBody Post post,
                                         HttpServletRequest request) {
    Post createdPost = this.blogService.createPost(post);
    return new ResponseEntity<>(createdPost, HttpStatus.OK);
  }

  @RequestMapping(value = "/api/admin/posts/{postId}", method = RequestMethod.DELETE)
  public void deletePostById(@PathVariable(value = "postId") Integer postId) {
    LOGGER.debug("Delete Post id: " + postId);
    blogService.deletePost(postId);
  }
}
