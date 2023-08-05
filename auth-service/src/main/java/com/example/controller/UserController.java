package com.example.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

	@RabbitListener(queues = MessageConfig.QUEUE)
	public void saveUserAndlistenMessage(@RequestBody User user) {
		service.addUser(user);
		System.out.println(user);
	}
}
