package com.DtoValidationSpring.DTOValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DtoValidationSpring.DTOValidation.DTO.FeedingDTO;
import com.DtoValidationSpring.DTOValidation.DTO.FeedingResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.Feeding;
import com.DtoValidationSpring.DTOValidation.Entity.Pet;
import com.DtoValidationSpring.DTOValidation.Repository.FeedingRepo;
import com.DtoValidationSpring.DTOValidation.Repository.PetRepo;

@Service
public class FeedingService {

	@Autowired
	private FeedingRepo feedingRepository;

	@Autowired
	private PetRepo petRepository;

	// ================= ADD =================
	public FeedingResponseDTO addFeeding(Long petId, FeedingDTO dto) {

		Pet pet = petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));

		Feeding feeding = new Feeding();
		feeding.setFoodName(dto.getFoodName());
		feeding.setTime(dto.getTime());
		feeding.setQuantity(dto.getQuantity());
		feeding.setPet(pet);

		Feeding saved = feedingRepository.save(feeding);
		return mapToResponseDTO(saved);
	}

	// ================= GET ALL (View More) =================
	@Transactional(readOnly = true)
	public List<FeedingResponseDTO> getAllFeedingsByPet(Long petId) {

		List<Feeding> feedings = feedingRepository.findByPet_PetId(petId);

		return feedings.stream().map(this::mapToResponseDTO).toList();
	}

	// ================= GET BY ID =================
	@Transactional(readOnly = true)
	public FeedingResponseDTO getFeedingById(Long feedingId) {

		Feeding feeding = feedingRepository.findById(feedingId)
				.orElseThrow(() -> new RuntimeException("Feeding record not found"));

		return mapToResponseDTO(feeding);
	}

	// ================= UPDATE =================
	public FeedingResponseDTO updateFeeding(Long feedingId, FeedingDTO dto) {

		Feeding feeding = feedingRepository.findById(feedingId)
				.orElseThrow(() -> new RuntimeException("Feeding record not found"));

		feeding.setFoodName(dto.getFoodName());
		feeding.setTime(dto.getTime());
		feeding.setQuantity(dto.getQuantity());

		Feeding updated = feedingRepository.save(feeding);
		return mapToResponseDTO(updated);
	}

	// ================= DELETE =================
	public void deleteFeeding(Long feedingId) {

		Feeding feeding = feedingRepository.findById(feedingId)
				.orElseThrow(() -> new RuntimeException("Feeding record not found"));

		feedingRepository.delete(feeding);
	}

	// ================= MAPPER =================
	private FeedingResponseDTO mapToResponseDTO(Feeding feeding) {

		FeedingResponseDTO dto = new FeedingResponseDTO();
		dto.setId(feeding.getId());
		dto.setFoodName(feeding.getFoodName());
		dto.setTime(feeding.getTime());
		dto.setQuantity(feeding.getQuantity());

		return dto;
	}
}
