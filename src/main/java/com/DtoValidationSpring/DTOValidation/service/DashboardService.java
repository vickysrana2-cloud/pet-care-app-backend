package com.DtoValidationSpring.DTOValidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DtoValidationSpring.DTOValidation.DTO.DashboardResponseDTO;

@Service
public class DashboardService {

    @Autowired
    private PetService petService;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private HealthService healthService;

    public DashboardResponseDTO getDashboardSummary(Long userId) {

        DashboardResponseDTO dto = new DashboardResponseDTO();
        dto.setUserId(userId);

        dto.setTotalPets(petService.getPetCountByUser(userId));
        dto.setTotalReminders(reminderService.getReminderCountByUser(userId));
        dto.setTotalHealth(healthService.getHealthCountByUser(userId));

        return dto;
    }
}

