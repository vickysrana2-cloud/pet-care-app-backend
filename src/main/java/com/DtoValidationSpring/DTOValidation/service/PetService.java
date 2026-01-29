package com.DtoValidationSpring.DTOValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DtoValidationSpring.DTOValidation.DTO.FeedingResponseDTO;
import com.DtoValidationSpring.DTOValidation.DTO.HealthResponseDTO;
import com.DtoValidationSpring.DTOValidation.DTO.PetDTO;
import com.DtoValidationSpring.DTOValidation.DTO.ReminderResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.Feeding;
import com.DtoValidationSpring.DTOValidation.Entity.Health;
import com.DtoValidationSpring.DTOValidation.Entity.Pet;
import com.DtoValidationSpring.DTOValidation.Entity.Reminder;
import com.DtoValidationSpring.DTOValidation.Entity.User;
import com.DtoValidationSpring.DTOValidation.Repository.PetRepo;
import com.DtoValidationSpring.DTOValidation.Repository.UserRepo;
import com.DtoValidationSpring.DTOValidation.DTO.PetDetailResponseDTO;


@Service
public class PetService {

	@Autowired
	private PetRepo petRepo;

	@Autowired
	private UserRepo userRepo;

	// ADD PET
	public Pet addPet(PetDTO dto, Long userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Pet pet = new Pet();

		pet.setName(dto.getName());
		pet.setSpecies(dto.getSpecies());
		pet.setBreed(dto.getBreed());
		pet.setBirthDate(dto.getBirthDate());
		pet.setWeight(dto.getWeight());
		pet.setPhotoUrl(dto.getPhotoUrl());

		pet.setUser(user);
		return petRepo.save(pet);
	}

	public List<Pet> getAllPets() {
		return petRepo.findAll();
	}

	// GET ALL PETS OF LOGGED-IN USER
	public List<Pet> getMyPets(Long userId) {
		return petRepo.findByUser_Id(userId);
	}

	
	@Transactional(readOnly = true)
	public PetDetailResponseDTO getMyPetById(Long petId, Long userId) {

	    Pet pet = petRepo.findByPetIdAndUser_Id(petId, userId)
	            .orElseThrow(() -> new RuntimeException("Pet not found"));

	    PetDetailResponseDTO dto = new PetDetailResponseDTO();
	    dto.setPetId(pet.getPetId());
	    dto.setName(pet.getName());
	    dto.setSpecies(pet.getSpecies());
	    dto.setBreed(pet.getBreed());
	    dto.setBirthDate(pet.getBirthDate());
	    dto.setWeight(pet.getWeight());
	    dto.setPhotoUrl(pet.getPhotoUrl());

	    dto.setHealthRecords(
	            pet.getHealthRecords().stream()
	                    .map(this::mapToHealthResponseDTO)
	                    .toList()
	    );

	    dto.setFeedings(
	            pet.getFeedings().stream()
	                    .map(this::mapToFeedingResponseDTO)
	                    .toList()
	    );

	    dto.setReminders(
	            pet.getReminders().stream()
	                    .map(this::mapToReminderResponseDTO)
	                    .toList()
	    );

	    return dto;
	}

	
	
	public long getPetCountByUser(Long userId) {
	    return petRepo.countByUser_Id(userId);
	}


	 


	// UPDATE USER SPECIFIC PET
	public Pet updateMyPet(Long petId, Long userId, PetDTO dto) {

		Pet pet = petRepo.findByPetIdAndUser_Id(petId, userId).orElseThrow(() -> new RuntimeException("Pet not found"));

		pet.setName(dto.getName());
		pet.setSpecies(dto.getSpecies());
		pet.setBreed(dto.getBreed());
		pet.setBirthDate(dto.getBirthDate());
		pet.setWeight(dto.getWeight());
		pet.setPhotoUrl(dto.getPhotoUrl());

		return petRepo.save(pet);
	}

	// DELETE USER SPECIFIC PET
	public void deleteMyPet(Long petId, Long userId) {

		Pet pet = petRepo.findByPetIdAndUser_Id(petId, userId).orElseThrow(() -> new RuntimeException("Pet not found"));

		petRepo.delete(pet);
	}
	
	
	public List <Pet> searchBySpecies(String species) {
		return petRepo.findBySpecies(species);
	}
	
	
	public List <Pet> searchByBreed(String breed) {
		return petRepo.findByBreed(breed);
	}
	
	
	
	private HealthResponseDTO mapToHealthResponseDTO(Health h) {
	    return new HealthResponseDTO(
	            h.getId(),
	            h.getType(),
	            h.getDescription(),
	            h.getDate(),
	            h.getVetName()
	    );
	}

	private FeedingResponseDTO mapToFeedingResponseDTO(Feeding f) {
	    return new FeedingResponseDTO(
	            f.getId(),
	            f.getFoodName(),
	            f.getTime(),
	            f.getQuantity()
	    );
	}

	private ReminderResponseDTO mapToReminderResponseDTO(Reminder r) {
	    return new ReminderResponseDTO(
	            r.getId(),
	            r.getTitle(),
	            r.getReminderDate(),
	            r.getNotes()
	    );
	}

	
}
