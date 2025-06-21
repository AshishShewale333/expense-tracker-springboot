package com.expensetrackerapi.service;

import com.expensetrackerapi.entity.User;
import com.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel model);

	User getUserById(Long id);
	
	User updateUser(Long id, UserModel user);
	
	void deleteUserById(Long id);
	
}
