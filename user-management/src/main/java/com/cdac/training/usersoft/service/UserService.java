package com.cdac.training.usersoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.repository.UserRepository;

/**
 * Author : nitik
 * Date : 31 Dec 2024
 * Time : 9:41:00 pm
*/

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void UserRegister(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> UserLogin(String email, String password){
		return userRepository.findByEmail(email).filter(user -> user.getPassword().equals(password));
	}

}
