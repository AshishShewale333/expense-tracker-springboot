package com.expensetrackerapi.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

	@NotBlank(message = "Please enter name")
	private String name;
	
	@NotNull(message = "Please enter name")
	@Email(message = "Please enter valid email")
	private String email;
	
	@NotNull(message = "please enter password")
	@Size(min=6, message = "Password must contain atleast 6 characters")
	private String password;
	
	private Long age = 0L;

}
