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

import com.DtoValidationSpring.DTOValidation.DTO.ReminderDTO;
import com.DtoValidationSpring.DTOValidation.DTO.ReminderResponseDTO;
import com.DtoValidationSpring.DTOValidation.service.ReminderService;

@RestController
@RequestMapping("/api/pets/{petId}/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    // ================= ADD =================
    @PostMapping
    public ReminderResponseDTO addReminder(
            @PathVariable Long petId,
            @RequestBody ReminderDTO dto) {

        return reminderService.addReminder(petId, dto);
    }

    // ================= GET ALL (View More) =================
    @GetMapping
    public List<ReminderResponseDTO> getAllReminders(
            @PathVariable Long petId) {

        return reminderService.getAllRemindersByPet(petId);
    }
    


    // ================= GET BY ID =================
    @GetMapping("/{reminderId}")
    public ReminderResponseDTO getReminderById(
            @PathVariable Long reminderId) {

        return reminderService.getReminderById(reminderId);
    }

    // ================= UPDATE =================
    @PutMapping("/{reminderId}")
    public ReminderResponseDTO updateReminder(
            @PathVariable Long reminderId,
            @RequestBody ReminderDTO dto) {

        return reminderService.updateReminder(reminderId, dto);
    }

    // ================= DELETE =================
    @DeleteMapping("/{reminderId}")
    public void deleteReminder(
            @PathVariable Long reminderId) {

        reminderService.deleteReminder(reminderId);
    }
}

