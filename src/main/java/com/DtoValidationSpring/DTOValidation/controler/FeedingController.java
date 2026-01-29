package com.DtoValidationSpring.DTOValidation.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DtoValidationSpring.DTOValidation.DTO.FeedingDTO;
import com.DtoValidationSpring.DTOValidation.DTO.FeedingResponseDTO;
import com.DtoValidationSpring.DTOValidation.service.FeedingService;

@RestController
@RequestMapping("/api/pets/{petId}/feeding")
public class FeedingController {

    @Autowired
    private FeedingService feedingService;

    // ================= ADD =================
    @PostMapping
    public FeedingResponseDTO addFeeding(
            @PathVariable Long petId,
            @RequestBody FeedingDTO dto) {

        return feedingService.addFeeding(petId, dto);
    }

    // ================= GET ALL (View More) =================
    @GetMapping
    public List<FeedingResponseDTO> getAllFeedings(
            @PathVariable Long petId) {

        return feedingService.getAllFeedingsByPet(petId);
    }

    // ================= GET BY ID =================
    @GetMapping("/{feedingId}")
    public FeedingResponseDTO getFeedingById(
            @PathVariable Long feedingId) {

        return feedingService.getFeedingById(feedingId);
    }

    // ================= UPDATE =================
    @PutMapping("/{feedingId}")
    public FeedingResponseDTO updateFeeding(
            @PathVariable Long feedingId,
            @RequestBody FeedingDTO dto) {

        return feedingService.updateFeeding(feedingId, dto);
    }

    // ================= DELETE =================
    @DeleteMapping("/{feedingId}")
    public void deleteFeeding(
            @PathVariable Long feedingId) {

        feedingService.deleteFeeding(feedingId);
    }
}

