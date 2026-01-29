package com.DtoValidationSpring.DTOValidation.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotBlank
	@Size(min=3, max=20, message="20 characters allowed")
	private String name;
	
	@Email(message="invalid email formate")
	@NotBlank
	private String email;
	
	@NotBlank(message="password is required")
	private String password;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDTO(@NotBlank @Size(min = 3, max = 20, message = "20 characters allowed") String name,
			@Email(message = "invalid email formate") @NotBlank String email,
			@NotBlank(message = "password is required") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
