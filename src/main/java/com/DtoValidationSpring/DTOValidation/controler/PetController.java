package com.DtoValidationSpring.DTOValidation.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DtoValidationSpring.DTOValidation.DTO.PetDTO;
import com.DtoValidationSpring.DTOValidation.DTO.PetDetailResponseDTO;
import com.DtoValidationSpring.DTOValidation.DTO.PetResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.Pet;
import com.DtoValidationSpring.DTOValidation.service.PetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetService petService;

	// ADD PET WITH USER
	@PostMapping("/add/{userId}")
	public PetResponseDTO addPet(@RequestBody @Valid PetDTO dto, @PathVariable Long userId) {
		Pet savedPet = petService.addPet(dto, userId);
		return mapToResponseDTO(savedPet);
	}

	// ----------------- Admin use only (or remove later)
	@GetMapping
	public List<PetResponseDTO> getAllPets() {
		List<Pet> pets = petService.getAllPets();
		return pets.stream().map(this::mapToResponseDTO).toList();
	}

	@GetMapping("/user/{userId}")
	public List<PetResponseDTO> getMyPets(@PathVariable Long userId) {
		return petService.getMyPets(userId).stream().map(this::mapToResponseDTO).toList();
	}

	@PutMapping("/{petId}/user/{userId}")
	public PetResponseDTO updateMyPet(@PathVariable Long petId, @PathVariable Long userId,
			@RequestBody @Valid PetDTO dto) {
		Pet pet = petService.updateMyPet(petId, userId, dto);

		return mapToResponseDTO(pet);
	}

	// DELETE MAPPING
	@DeleteMapping("/{petId}/user/{userId}")
	public String deleteMyPet(@PathVariable Long petId, @PathVariable Long userId) {
		petService.deleteMyPet(petId, userId);
		return "Pet deleted successfully";
	}

	// GET SINGLE PET
	@GetMapping("/{petId}/user/{userId}")
	public  PetDetailResponseDTO getMyPet(@PathVariable Long petId, @PathVariable Long userId) {

		return petService.getMyPetById(petId, userId);
	}

	@GetMapping("/search")
	public List <Pet> searchPets(@RequestParam(required=false) String species,
			@RequestParam(required=false) String breed) {
		
		if(species != null) {
			return petService.searchBySpecies(species);
		}else if(breed != null) {
			return petService.searchByBreed(breed);
		}
		
		return petService.getAllPets();
	}
    
    
    
 // -------- helper method --------

	private PetResponseDTO mapToResponseDTO(Pet pet) {
		return new PetResponseDTO(pet.getPetId(), pet.getName(), pet.getSpecies(), pet.getBreed(), pet.getBirthDate(),
				pet.getWeight(), pet.getPhotoUrl());
	}

}
