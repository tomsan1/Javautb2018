package java1;

import java.time.ZonedDateTime;

public class Appointment {
	
	Employe employe;
	Customer customer;
	
	String description;
	ZonedDateTime startTime;
	ZonedDateTime endTime;
	
	public void setTime(ZonedDateTime startTime, ZonedDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		
	}
	public void setEmploye(Employe employer) {
		this.employe = employer;
	}

}
