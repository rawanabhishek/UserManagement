package com.bridgelabz.usermanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	
	@JsonIgnoreProperties(value = "privilege")
	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Permission> permissions;
	
   

	@JsonIgnoreProperties(value = "privileges")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
