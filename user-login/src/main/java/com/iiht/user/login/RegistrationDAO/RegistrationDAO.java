package com.iiht.user.login.RegistrationDAO
;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.user.login.model.RegisterUser;

public interface RegistrationDAO extends JpaRepository<RegisterUser,String> {
  
	RegisterUser findByEmail(String email);
}
