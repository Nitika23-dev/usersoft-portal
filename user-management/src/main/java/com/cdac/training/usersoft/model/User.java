package com.cdac.training.usersoft.model;

import jakarta.persistence.*;

/**
 * Author : nitik
 * Date : 31 Dec 2024
 * Time : 9:40:02 pm
*/
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable=false, unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;

	public Long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
}
