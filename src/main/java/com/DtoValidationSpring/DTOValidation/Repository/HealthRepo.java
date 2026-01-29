package com.DtoValidationSpring.DTOValidation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DtoValidationSpring.DTOValidation.Entity.Health;

public interface HealthRepo extends JpaRepository<Health, Long>{
	List<Health> findByPet_PetId(Long petId);
	
	long countByPet_User_Id(Long userId);

}
