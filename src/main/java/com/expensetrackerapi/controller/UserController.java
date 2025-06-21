package com.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetrackerapi.entity.Expense;
import com.expensetrackerapi.entity.User;
import com.expensetrackerapi.entity.UserModel;
import com.expensetrackerapi.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	 
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") Long id,@RequestBody UserModel user) {
	 User updateUser = userService.updateUser(id, user);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
        return ResponseEntity.noContent().build(); 
    }
}
