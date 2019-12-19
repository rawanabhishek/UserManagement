/******************************************************************************
 *  Purpose: Utility class for users of user management 
 *
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.utility;

import com.bridgelabz.usermanagement.dto.UserDTO;
import com.bridgelabz.usermanagement.entity.User;

public class UserUtility {
	
	public static User map(UserDTO userDTO, User user) {
		user.setFirstName(userDTO.getFirstName());
		user.setMiddleName(userDTO.getMiddleName());
		user.setLastName(userDTO.getLastName());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setGender(userDTO.getGender());
		user.setCountry(userDTO.getCountry());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setPrivileges(userDTO.getPrivileges());
		return user;
	}

}