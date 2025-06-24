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

	@GetMapping("/profile")
	public ResponseEntity<User> getUserById() {
		User user = userService.getUserById();
		return ResponseEntity.ok(user);
	}

	@PutMapping("/profile")
	public ResponseEntity<User> updateUserById(@RequestBody UserModel user) {
		User updateUser = userService.updateUser(user);
		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/deactivate")
	public ResponseEntity<Void> deleteUserById() {
		userService.deleteUserById();
		return ResponseEntity.noContent().build();
	}
}
