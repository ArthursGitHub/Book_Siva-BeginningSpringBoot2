package com.apress.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.apress.demo.entities.Message;
import com.apress.demo.repositories.MessageRepository;

@Controller
public class HomeController {
  @Autowired
  private MessageRepository messageRepository;

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("msgs", messageRepository.findAll());
    return "userhome";
  }

  @PostMapping("/messages")
  public String saveMessage(Message message) {
    messageRepository.save(message);
    return "redirect:/home";
  }
	
	/*
	@RequestMapping(value="/403")
	public String accessDenied()
	{
		return "error/403";
	}
	*/
}
