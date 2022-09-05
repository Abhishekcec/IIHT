package com.estockmarket.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estockmarket.authentication.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByEmail(String email);

//	@Query("select * from User where username = :username")
	User findByUserName(String username);

}
