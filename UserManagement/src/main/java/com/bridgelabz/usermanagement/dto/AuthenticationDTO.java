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

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean rememberMe;
	
	private boolean forgotPassword;
	
	private String name;


}
