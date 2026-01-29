package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;

public class PetResponseDTO {

	private Long petId;
	private String name;
	private String species;
	private String breed;
	private LocalDate birthDate;
	private Double weight;
	private String photoUrl;

	public PetResponseDTO() {
	}

	public PetResponseDTO(Long petId, String name, String species, String breed, LocalDate birthDate, Double weight,
			String photoUrl) {
		this.petId = petId;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.birthDate = birthDate;
		this.weight = weight;
		this.photoUrl = photoUrl;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
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
