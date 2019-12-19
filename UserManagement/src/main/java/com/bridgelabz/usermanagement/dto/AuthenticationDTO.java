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

import lombok.Data;

@Data
public class AuthenticationDTO {
	private boolean rememeberMe;
	
	private boolean forgotPassword;
	
	private String name;


}
