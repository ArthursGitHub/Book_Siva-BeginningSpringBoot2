package com.apress.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.apress.demo.SpringbootJdbcDemoApplication;
import com.apress.demo.User;
import com.apress.demo.UserRepository;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJdbcDemoApplication.class)
public class SpringbootJdbcDemoApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void findAllUsers() {
    List<User> users = userRepository.findAll();
    assertNotNull(users);
    assertTrue(!users.isEmpty());
  }

  @Test
  public void findUserById() {
    User user = userRepository.findUserById(1);
    assertNotNull(user);
  }

  @Test
  public void createUser() {
    User user = new User(0, "Siva", "siva@gmail.com");
    User savedUser = userRepository.create(user);
    User newUser = userRepository.findUserById(savedUser.getId());
    assertEquals("Siva", newUser.getName());
    assertEquals("siva@gmail.com", newUser.getEmail());
  }
}
