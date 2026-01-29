package com.DtoValidationSpring.DTOValidation.DTO;

public class DashboardResponseDTO {

	 private Long userId;

	    private long totalPets;
	    private long totalReminders;
	    private long totalHealth;

	    // optional future use
	    // private long totalFeeding;
	    // private long upcomingReminders;

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public long getTotalPets() {
	        return totalPets;
	    }

	    public void setTotalPets(long totalPets) {
	        this.totalPets = totalPets;
	    }

	    public long getTotalReminders() {
	        return totalReminders;
	    }

	    public void setTotalReminders(long totalReminders) {
	        this.totalReminders = totalReminders;
	    }

	    public long getTotalHealth() {
	        return totalHealth;
	    }

	    public void setTotalHealth(long totalHealth) {
	        this.totalHealth = totalHealth;
	    }
	
}
