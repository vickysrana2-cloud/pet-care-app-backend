package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;

public class HealthDTO {
	//HealthRequestDTO
	
	@NotBlank(message="Type is required")
	private String type;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@NotBlank(message="Date is required")
	private LocalDate date;
	
	@NotBlank(message="VetName is required")
	private String vetName;
	

	public HealthDTO(@NotBlank(message = "Type is required") String type,
			@NotBlank(message = "Description is required") String description,
			@NotBlank(message = "Date is required") LocalDate date,
			@NotBlank(message = "VetName is required") String vetName) {
		super();
		this.type = type;
		this.description = description;
		this.date = date;
		this.vetName = vetName;
	}

	public HealthDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVetName() {
		return vetName;
	}

	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	
	
	
	
}
