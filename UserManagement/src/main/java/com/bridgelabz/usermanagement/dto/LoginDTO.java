/******************************************************************************
 
 *  Purpose: A class which is a  simple DTO(Data Transfer Object) which can map
 *  		 the values to this class on the basis of the user response which
 *  		 is catch by RequestBody annotation and then mapping into this use
 *           POJO class.
 *  		  
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   20-10-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.dto;


import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class LoginDTO {
	

	private String userName;
	
	@NotNull(message="please provide password")
	private String password;
	
	

}
