package java1;

import java.time.LocalDateTime;

public class Appointment {
	
	Employe employe;
	Customer customer;
	
	String description;
	LocalDateTime startTime;
	LocalDateTime endTime;
	
	public Appointment(Employe employe, Customer customer, LocalDateTime startTime, LocalDateTime endTime) {
		
		this.employe = employe;
		this.customer = customer;
		this.setTime(startTime, endTime);
		
	}
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	public  void setTime(LocalDateTime startTime, LocalDateTime endTime) {
	
			//will need some check to se time is availible
			this.startTime = startTime;
			this.endTime = endTime;
	}
	
	public void setEmploye(Employe employer) {
		this.employe = employer;
	}
	public Employe getEmploye() {
		return this.employe;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public int getDurationAsMinutes() {
		
		int minutes = 0 ;	
		
		minutes = (this.getEndTime().getHour() - this.getStartTime().getHour()); 
		minutes = minutes * 60;
		minutes = minutes + (this.getEndTime().getMinute() -this.getStartTime().getMinute());
		
		return minutes;
	}
	
	
	
}
