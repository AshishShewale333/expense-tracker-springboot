package com.expensetrackerapi.service;

import com.expensetrackerapi.entity.User;
import com.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel model);

	User getUserById();
	
	User updateUser(UserModel user);
	
	void deleteUserById();
	
	User getLoggedInUser();
}
