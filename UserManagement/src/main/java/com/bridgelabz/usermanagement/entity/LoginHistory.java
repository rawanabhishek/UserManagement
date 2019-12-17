package com.bridgelabz.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginHistoryId;
	
	@Column(name = "login_time")
	private Date loginHistory;
	
	@JsonIgnoreProperties(value = "logins")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
