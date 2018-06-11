package com.apress.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoUserService {
  @Autowired
  private MongoTemplate mongoTemplate;

  public User getUser(Integer id) {
    Query query = Query.query(Criteria.where("id").is(id));
    return mongoTemplate.findOne(query, User.class);
  }

  public List<User> getUsers() {
    return mongoTemplate.findAll(User.class, "users");
  }

  public void createUser(User user) {
    mongoTemplate.save(user, "users");
  }
}
