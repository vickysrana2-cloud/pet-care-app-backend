package com.DtoValidationSpring.DTOValidation.DTO;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;

public class FeedingDTO {
	//FeedingRequestDTO
	
	@NotBlank(message="FoodName is required")
	private String foodName;
	
	@NotBlank(message="Time is required")
	private LocalTime time;
	
	@NotBlank(message="Quantity is required")
	private Double quantity;

	public FeedingDTO(@NotBlank(message = "FoodName is required") String foodName,
			@NotBlank(message = "Time is required") LocalTime time,
			@NotBlank(message = "Quantity is required") Double quantity) {
		super();
		this.foodName = foodName;
		this.time = time;
		this.quantity = quantity;
	}

	public FeedingDTO() {
		super();
		// TODO Auto-generated constructor stub
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
