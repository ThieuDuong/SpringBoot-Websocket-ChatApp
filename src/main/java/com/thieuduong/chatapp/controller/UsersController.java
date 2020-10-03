package com.thieuduong.chatapp.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thieuduong.chatapp.storage.UserStorage;

@RestController
@CrossOrigin
public class UsersController {
	@GetMapping("/registration/{userName}")
	public ResponseEntity<Void> register(@PathVariable("userName") String userName){
		System.out.println("handling register user request: " + userName);
		try {
			UserStorage.getInstance().setUsers(userName);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/getAllUsers")
	public Set<String> getAllUsers(){
		return UserStorage.getInstance().getUsers();
	}
}
