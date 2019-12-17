package com.bridgelabz.usermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Privilege {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int privilegeId;
	
	
	private boolean add;
	

	private boolean delete;
	

	private boolean modify;
	

	private boolean read;
	
	@JsonIgnoreProperties(value = "privileges")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
