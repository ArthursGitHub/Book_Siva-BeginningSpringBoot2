package com.apress.demo.mappers;

import java.util.List;

import com.apress.demo.domain.User;

public interface UserMapper {
  void insertUser(User user);
  User findUserById(Integer id);
  List<User> findAllUsers();
}
