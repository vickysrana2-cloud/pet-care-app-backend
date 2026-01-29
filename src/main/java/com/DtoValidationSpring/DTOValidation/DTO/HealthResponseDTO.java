package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;

public class HealthResponseDTO {


	private Long id;
	private String type;
	private String description;
	private LocalDate date;
	private String vetName;
	
	public HealthResponseDTO(Long id, String type, String description, LocalDate date, String vetName) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.date = date;
		this.vetName = vetName;
	}

	public HealthResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
