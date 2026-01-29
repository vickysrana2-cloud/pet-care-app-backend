package com.DtoValidationSpring.DTOValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DtoValidationSpring.DTOValidation.DTO.HealthDTO;
import com.DtoValidationSpring.DTOValidation.DTO.HealthResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.Health;
import com.DtoValidationSpring.DTOValidation.Entity.Pet;
import com.DtoValidationSpring.DTOValidation.Repository.HealthRepo;
import com.DtoValidationSpring.DTOValidation.Repository.PetRepo;

@Service
public class HealthService {

	@Autowired
	private HealthRepo healthRepo;

	@Autowired
	private PetRepo petRepo;

	public HealthResponseDTO addHealth(Long PetId, HealthDTO dto) {

		Pet pet = petRepo.findById(PetId).orElseThrow(() -> new RuntimeException("Pet not found"));

		Health health = new Health();

		health.setDate(dto.getDate());
		health.setDescription(dto.getDescription());
		health.setType(dto.getType());
		health.setVetName(dto.getVetName());
		health.setPet(pet);

		Health saved = healthRepo.save(health);
		return mapToResponseDTO(saved);
	}

	
	public List<HealthResponseDTO> getAllHealthByPet(Long petId){
		
		List<Health> healthList = healthRepo.findByPet_PetId(petId);
		
		return healthList.stream().map(this::mapToResponseDTO).toList();
	}
	
	
	
	public long getHealthCountByUser(Long userId) {
	    return healthRepo.countByPet_User_Id(userId);
	}

	
	

	public HealthResponseDTO getHealthById(Long healthId) {
		Health health = healthRepo.findById(healthId).orElseThrow(()->new RuntimeException("Health record not found"));
		return mapToResponseDTO(health);
	}
	
	
	
    // ================= UPDATE =================
    public HealthResponseDTO updateHealth(Long healthId, HealthDTO dto) {

        Health health = healthRepo.findById(healthId)
                .orElseThrow(() -> new RuntimeException("Health record not found"));

        health.setType(dto.getType());
        health.setDescription(dto.getDescription());
        health.setDate(dto.getDate());
        health.setVetName(dto.getVetName());

        Health updated = healthRepo.save(health);
        return mapToResponseDTO(updated);
    }

    // ================= DELETE =================
    public void deleteHealth(Long healthId) {

        Health health = healthRepo.findById(healthId)
                .orElseThrow(() -> new RuntimeException("Health record not found"));

        healthRepo.delete(health);
    }
	
	
	

	private HealthResponseDTO mapToResponseDTO(Health health) {

		HealthResponseDTO dto = new HealthResponseDTO();

		dto.setId(health.getId());
		dto.setDate(health.getDate());
		dto.setDescription(health.getDescription());
		dto.setType(health.getType());
		dto.setVetName(health.getVetName());

		return dto;

	}

}
