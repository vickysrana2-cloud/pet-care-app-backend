package com.DtoValidationSpring.DTOValidation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DtoValidationSpring.DTOValidation.Entity.Reminder;

public interface ReminderRepo extends JpaRepository<Reminder, Long> {
    List<Reminder> findByPet_PetId(Long petId);
    
    long countByPet_User_Id(Long userId);

}
