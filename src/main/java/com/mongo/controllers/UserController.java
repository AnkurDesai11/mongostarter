package com.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.entities.User;
import com.mongo.repos.UserRepository;
import com.mongo.services.AutoIncrementService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AutoIncrementService autoIncrementService;
	
	@GetMapping("/")
	public ResponseEntity<?> getUsers(){
		return ResponseEntity.ok(this.userRepository.findAll());
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user){
		//generate sequence
		user.setId(this.autoIncrementService.getNextSequenceId("user_sequence"));
		this.userRepository.save(user);
		return ResponseEntity.ok(user);
	}
	
}
