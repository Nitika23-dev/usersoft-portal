package com.cdac.training.usersoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.usersoft.model.User;

/**
 * Author : nitik
 * Date : 31 Dec 2024
 * Time : 9:40:24 pm
*/
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
