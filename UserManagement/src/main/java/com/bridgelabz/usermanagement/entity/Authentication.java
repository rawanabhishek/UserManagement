/******************************************************************************
 
 *  Purpose:  A Class  for creating the POJO class Of UserManagement Authentication and 
 *           this this class uses Entity to get know spring that it is POJO class.
 *  		 
 *  @author   Abhishek Rawat
 *  @version  1.0
 *  @since    17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Authentication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	
	private boolean rememeberMe;
	
	private boolean forgotPassword;
	
	private String name;


}