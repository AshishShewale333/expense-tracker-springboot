package com.expensetrackerapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetrackerapi.entity.Expense;
import com.expensetrackerapi.entity.User;
import com.expensetrackerapi.entity.UserModel;
import com.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.expensetrackerapi.repository.UserRepository;
import com.expensetrackerapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserModel user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User already registered with email " + user.getEmail());
		}
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for the id "+id));
	}
	
	public User updateUser(Long id, UserModel user) {
		User existingUser = getUserById(id); // fetch existing user

		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());

		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());

		existingUser.setPassword(user.getPassword() != null  ? user.getPassword(): existingUser.getPassword());

		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());

		return userRepository.save(existingUser);
	}
	
	public void deleteUserById(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
	}

	
	
}
