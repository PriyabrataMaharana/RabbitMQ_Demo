package com.example.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.MessageConfig;
import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RabbitTemplate template;
	
	
	@PostMapping("/user")
	public String postUser(@RequestBody User user) {
		service.postUser(user);
		template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, user);
		return "Successfully done !!";
	}
}
