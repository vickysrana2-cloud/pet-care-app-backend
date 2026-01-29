package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;
import java.util.List;

public class PetDetailResponseDTO {

	 private Long petId;
	    private String name;
	    private String species;
	    private String breed;
	    private LocalDate birthDate;
	    private Double weight;
	    private String photoUrl;

	    private List<HealthResponseDTO> healthRecords;
	    private List<FeedingResponseDTO> feedings;
	    private List<ReminderResponseDTO> reminders;
	    
	    
		public PetDetailResponseDTO(Long petId, String name, String species, String breed, LocalDate birthDate,
				Double weight, String photoUrl, List<HealthResponseDTO> healthRecords,
				List<FeedingResponseDTO> feedings, List<ReminderResponseDTO> reminders) {
			super();
			this.petId = petId;
			this.name = name;
			this.species = species;
			this.breed = breed;
			this.birthDate = birthDate;
			this.weight = weight;
			this.photoUrl = photoUrl;
			this.healthRecords = healthRecords;
			this.feedings = feedings;
			this.reminders = reminders;
		}


		public PetDetailResponseDTO() {
			super();
			// TODO Auto-generated constructor stub
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


		public List<HealthResponseDTO> getHealthRecords() {
			return healthRecords;
		}


		public void setHealthRecords(List<HealthResponseDTO> healthRecords) {
			this.healthRecords = healthRecords;
		}


		public List<FeedingResponseDTO> getFeedings() {
			return feedings;
		}


		public void setFeedings(List<FeedingResponseDTO> feedings) {
			this.feedings = feedings;
		}


		public List<ReminderResponseDTO> getReminders() {
			return reminders;
		}


		public void setReminders(List<ReminderResponseDTO> reminders) {
			this.reminders = reminders;
		}
	    
	    
	    
	    
}
