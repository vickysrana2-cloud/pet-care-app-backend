package com.DtoValidationSpring.DTOValidation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DtoValidationSpring.DTOValidation.Entity.Feeding;

public interface FeedingRepo extends JpaRepository<Feeding , Long> {
	List<Feeding> findByPet_PetId(Long petId);

}
