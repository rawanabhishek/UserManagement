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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;

	private String permissionName;
	
	private boolean add;
	

	private boolean delete;
	

	private boolean modify;
	

	private boolean read;
	
	@JsonIgnoreProperties(value = "permissions")
	@ManyToOne(fetch = FetchType.LAZY)
	private Privilege privileges;
	
	

}
