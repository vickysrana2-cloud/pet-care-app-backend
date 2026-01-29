package com.DtoValidationSpring.DTOValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DtoValidationSpring.DTOValidation.DTO.ReminderDTO;
import com.DtoValidationSpring.DTOValidation.DTO.ReminderResponseDTO;
import com.DtoValidationSpring.DTOValidation.Entity.Pet;
import com.DtoValidationSpring.DTOValidation.Entity.Reminder;
import com.DtoValidationSpring.DTOValidation.Repository.PetRepo;
import com.DtoValidationSpring.DTOValidation.Repository.ReminderRepo;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepo reminderRepository;

    @Autowired
    private PetRepo petRepository;

    // ================= ADD =================
    public ReminderResponseDTO addReminder(Long petId, ReminderDTO dto) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        Reminder reminder = new Reminder();
        reminder.setTitle(dto.getTitle());
        reminder.setReminderDate(dto.getReminderDate());
        reminder.setNotes(dto.getNotes());
        reminder.setPet(pet);

        Reminder saved = reminderRepository.save(reminder);
        return mapToResponseDTO(saved);
    }

    // ================= GET ALL (View More) =================
    @Transactional(readOnly = true)
    public List<ReminderResponseDTO> getAllRemindersByPet(Long petId) {

        List<Reminder> reminders = reminderRepository.findByPet_PetId(petId);

        return reminders.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    
    // ================= GET ALL Reminders by User Id =================
    
    public long getReminderCountByUser(Long userId) {
        return reminderRepository.countByPet_User_Id(userId);
    }


    
    // ================= GET BY ID =================
    @Transactional(readOnly = true)
    public ReminderResponseDTO getReminderById(Long reminderId) {

        Reminder reminder = reminderRepository.findById(reminderId)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));

        return mapToResponseDTO(reminder);
    }

    // ================= UPDATE =================
    public ReminderResponseDTO updateReminder(Long reminderId, ReminderDTO dto) {

        Reminder reminder = reminderRepository.findById(reminderId)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));

        reminder.setTitle(dto.getTitle());
        reminder.setReminderDate(dto.getReminderDate());
        reminder.setNotes(dto.getNotes());

        Reminder updated = reminderRepository.save(reminder);
        return mapToResponseDTO(updated);
    }

    // ================= DELETE =================
    public void deleteReminder(Long reminderId) {

        Reminder reminder = reminderRepository.findById(reminderId)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));

        reminderRepository.delete(reminder);
    }

    // ================= MAPPER =================
    private ReminderResponseDTO mapToResponseDTO(Reminder reminder) {

        ReminderResponseDTO dto = new ReminderResponseDTO();
        dto.setId(reminder.getId());
        dto.setTitle(reminder.getTitle());
        dto.setReminderDate(reminder.getReminderDate());
        dto.setNotes(reminder.getNotes());

        return dto;
    }
}

