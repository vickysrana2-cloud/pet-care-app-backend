package com.DtoValidationSpring.DTOValidation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DtoValidationSpring.DTOValidation.Entity.User;

public interface UserRepo extends JpaRepository<User , Long> {
	
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);
}





