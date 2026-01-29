package com.DtoValidationSpring.DTOValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DtoValidationSpring.DTOValidation.DTO.LoginRequestDTO;
import com.DtoValidationSpring.DTOValidation.DTO.UserDTO;
import com.DtoValidationSpring.DTOValidation.DTO.UserResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.User;
import com.DtoValidationSpring.DTOValidation.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserResponseDTO saveUser(UserDTO userDTO) {

		if (userRepo.existsByEmail(userDTO.getEmail())) {
			throw new RuntimeException("Email already exists");
		}

		User user = new User();

		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		User saved = userRepo.save(user);

		return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public UserResponseDTO login(LoginRequestDTO dto) {

		User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(() -> new RuntimeException("Email not found"));

		if (!user.getPassword().equals(dto.getPassword())) {
			throw new RuntimeException("Invalid password");
		}

		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
	}

}
