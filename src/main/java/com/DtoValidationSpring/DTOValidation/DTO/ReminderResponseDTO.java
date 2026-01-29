package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalDate;

public class ReminderResponseDTO {
	
	private Long id;
	private String title;
	private LocalDate reminderDate;
	private String notes;
	
	public ReminderResponseDTO(Long id, String title, LocalDate reminderDate, String notes) {
		super();
		this.id = id;
		this.title = title;
		this.reminderDate = reminderDate;
		this.notes = notes;
	}

	public ReminderResponseDTO() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
