package com.thieuduong.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.thieuduong.chatapp.model.Message;
import com.thieuduong.chatapp.storage.UserStorage;

@RestController
public class MessageController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat/{to}")
	public void sendMessage(@DestinationVariable String destinateUser, Message message) {
		System.out.println("handling send message: " + message + "to: " + destinateUser);
		boolean isUserExists = UserStorage.getInstance().getUsers().contains(destinateUser);
		if(isUserExists) {
			simpMessagingTemplate.convertAndSend("/topic/messages" + destinateUser, message);
		}
	}
	
	
}
