package com.DtoValidationSpring.DTOValidation.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DtoValidationSpring.DTOValidation.Entity.Pet;

public interface PetRepo extends JpaRepository<Pet, Long> {

	List<Pet> findByUser_Id(Long userId);
	
	Optional<Pet> findByPetIdAndUser_Id(Long petId, Long userId);
	
	List <Pet>findBySpecies (String species);
	
	List <Pet> findByBreed (String breed);
	
	long countByUser_Id(Long userId);

	
}
