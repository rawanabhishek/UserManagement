package com.bridgelabz.usermanagement.dto;


import java.util.List;

import com.bridgelabz.usermanagement.entity.LoginHistory;
import com.bridgelabz.usermanagement.entity.Privilege;

import lombok.Data;

@Data
public class UserDTO {
	private int userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String dateOfBirth;
	private String gender;
	private String country;
	private String phone;
	private String email;
	private String address;
	private String userName;
	private String password;
	private String role;
	private String profilePicture;
	
	
	private List<Privilege> privileges;
	private List<LoginHistory> logins;

}