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

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Authentication implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	
	private boolean rememberMe;
	
	private boolean forgotPassword;
	
	private String name;
	
	@JsonIgnoreProperties(value = "authSetting")
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	
	


}
