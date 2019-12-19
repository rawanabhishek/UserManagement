/******************************************************************************
 
 *  Purpose: A class which is a  simple DTO(Data Transfer Object) which can map
 *  		 the values to this class on the basis of the user response which
 *  		 is catch by RequestBody annotation and then mapping into this use
 *           POJO class.
 *  		  
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   19-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.dto;


import java.util.List;

import com.bridgelabz.usermanagement.entity.Authentication;
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
	private boolean status;
	
	private Authentication authSetting;
	private List<Privilege> privileges;
	private List<LoginHistory> logins;

}
