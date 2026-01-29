package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReminderDTO {
	// ReminderRequestDTO
	
	@NotBlank(message="Title is required")
	private String title;
	
	@NotNull(message = "Date is required")
	private LocalDate reminderDate;

	
	@NotBlank(message="Notes not be Blank")
	private String notes;

	public ReminderDTO(@NotBlank(message = "Title is required") String title,
			@NotNull(message = "Date is required") LocalDate reminderDate,
			@NotBlank(message = "Notes not be Blank") String notes) {
		super();
		this.title = title;
		this.reminderDate = reminderDate;
		this.notes = notes;
	}

	public ReminderDTO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDate reminderDate) {
		this.reminderDate = reminderDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
