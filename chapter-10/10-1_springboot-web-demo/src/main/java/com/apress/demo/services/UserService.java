package com.apress.demo.services;

import org.springframework.stereotype.Component;

@Component
public class UserService {
  private String message = "This is a test message";

  public String getMessage() {
    return message;
  }
}
