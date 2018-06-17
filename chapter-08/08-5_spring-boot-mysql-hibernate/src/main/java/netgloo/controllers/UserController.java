package netgloo.controllers;

import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserDao userDao;


  @RequestMapping(value = "/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      userDao.save(user);
    } catch (Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

  @RequestMapping(value = "/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    } catch (Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping(value = "/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    } catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
}
