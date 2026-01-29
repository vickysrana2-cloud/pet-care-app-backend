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

import com.DtoValidationSpring.DTOValidation.DTO.HealthDTO;
import com.DtoValidationSpring.DTOValidation.DTO.HealthResponseDTO;
import com.DtoValidationSpring.DTOValidation.service.HealthService;

@RestController
@RequestMapping("api/pets/{petId}/health")
public class HealthController {

    @Autowired
    private HealthService healthService;

    // ================= ADD =================
    @PostMapping
    public HealthResponseDTO addHealth(
            @PathVariable Long petId,
            @RequestBody HealthDTO dto) {

        return healthService.addHealth(petId, dto);
    }

    // ================= GET ALL (View More) =================
    @GetMapping
    public List<HealthResponseDTO> getAllHealth(
            @PathVariable Long petId) {

        return healthService.getAllHealthByPet(petId);
    }

    // ================= GET BY ID =================
    @GetMapping("/{healthId}")
    public HealthResponseDTO getHealthById(
            @PathVariable Long healthId) {

        return healthService.getHealthById(healthId);
    }

    // ================= UPDATE =================
    @PutMapping("/{healthId}")
    public HealthResponseDTO updateHealth(
            @PathVariable Long healthId,
            @RequestBody HealthDTO dto) {

        return healthService.updateHealth(healthId, dto);
    }

    // ================= DELETE =================
    @DeleteMapping("/{healthId}")
    public void deleteHealth(
            @PathVariable Long healthId) {

        healthService.deleteHealth(healthId);
    }
}

