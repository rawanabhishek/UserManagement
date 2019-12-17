package com.bridgelabz.usermanagement.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	

	private String firstName;
	

	private String middleName;
	

	private String lastName;
	

	private String dateOfBirth;
	
	
	private String gender;
	
	
	private String country;
	

	private String phone;
	
	@NotNull
	private String email;
	

	private String address;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String role;
	

	private boolean status;
	

	private String profilePicture;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	

	private Date lastLogin;
	
	@JsonIgnoreProperties(value = "user")
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Privilege> privileges;
	
	@JsonIgnoreProperties(value = "user")
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LoginHistory> logins;

}
