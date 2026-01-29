package com.DtoValidationSpring.DTOValidation.controler;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DtoValidationSpring.DTOValidation.DTO.LoginRequestDTO;
import com.DtoValidationSpring.DTOValidation.DTO.UserDTO;
import com.DtoValidationSpring.DTOValidation.DTO.UserResponseDTO;
import com.DtoValidationSpring.DTOValidation.service.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {
	
	private UserService userService;
	
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/signup")
	public UserResponseDTO signup(@Valid @RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}
	
	@PostMapping("/login")
	public UserResponseDTO login(@RequestBody LoginRequestDTO dto) {
		return userService.login(dto);
	}
}
