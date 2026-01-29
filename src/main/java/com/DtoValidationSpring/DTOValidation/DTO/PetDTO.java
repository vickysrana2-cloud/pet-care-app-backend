package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class PetDTO {

	@NotBlank(message="Pet name is required")
    private String name;

	@NotBlank(message="Species is required")
    private String species;

	private String breed;
	
	private LocalDate birthDate;
	
	@Positive(message="Weight must be positive")
	private Double weight;
	
	
	private String photoUrl;


	public PetDTO(@NotBlank(message = "Pet name is required") String name,
			@NotBlank(message = "Species is required") String species, String breed, LocalDate birthDate,
			@Positive(message = "Weight must be positive") Double weight, String photoUrl) {
		super();
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.birthDate = birthDate;
		this.weight = weight;
		this.photoUrl = photoUrl;
	}


	public PetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
	
	


}
