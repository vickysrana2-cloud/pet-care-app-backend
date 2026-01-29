package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalTime;

public class FeedingResponseDTO {
	
	private Long id;
	private String foodName;
	private LocalTime time;
	private Double quantity;
	
	
	
	public FeedingResponseDTO(Long id, String foodName, LocalTime time, Double quantity) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.time = time;
		this.quantity = quantity;
	}
	
	public FeedingResponseDTO() {
	}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	
}
