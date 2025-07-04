package com.expensetrackerapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserModel user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User already registered with email " + user.getEmail());
		}
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
	}

	@Override
	public User getUserById() {
		Long userId = getLoggedInUser().getId();
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found for the id "+userId));
	}
	
	public User updateUser(UserModel user) {
		User existingUser = getUserById(); // fetch existing user

		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());

		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());

		existingUser.setPassword(user.getPassword() != null  ? passwordEncoder.encode(user.getPassword()): existingUser.getPassword());

		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());

		return userRepository.save(existingUser);
	}
	
	public void deleteUserById() {
		User user = getUserById();
		userRepository.delete(user);
	}

	
	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getName();
		
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the email"+email));
	}
	
	
	

	
	
}
