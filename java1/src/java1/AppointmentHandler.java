package java1;

import java.util.ArrayList;

public class AppointmentHandler {
	
	ArrayList<Appointment> ap = new ArrayList<>();

	
	public void printOutAppointments() {
		for(Appointment currentAppointment : ap){
			System.out.println("---------------------------------");
			System.out.println("Kund:" + currentAppointment.customer.getFname() + " " + currentAppointment.customer.getLName());
			System.out.println("Frisör:" + currentAppointment.employe.getFname() + " " + currentAppointment.employe.getLName());
			System.out.println("Start:" + currentAppointment.startTime.toString());
			System.out.println("Slut:" + currentAppointment.endTime.toString());
			System.out.println("---------------------------------");
		}

			
	}
	
	public boolean insertAppointment(Appointment appointment) {
		
		//Checks if the appointment is ok then inserts it to the array
		if (isAvalible(appointment)) {
			ap.add(appointment);
			return true;
		}
			
		else { 
			return false;
		}	
		
	}
	
	public void removeAppointment(Appointment appointment) {
		//Create code for this will need some id in the Appointmentclass
	}
	
	private boolean isAvalible(Appointment appointment) {
		
		for(Appointment currentAppointment : ap) {
			
			if (currentAppointment.getEndTime().isAfter(appointment.getStartTime()) && ) {
					return false
			}
			//check to see if appointment start time is within range of current appointment in list
			/*if (appointment.getStartTime().isAfter(currentAppointment.getStartTime()) && appointment.getStartTime().isBefore(currentAppointment.getEndTime())){
				//check to see if appointment end time is within range of current appointment in list
				if (appointment.getEndTime().isAfter(currentAppointment.getStartTime()) && appointment.getEndTime().isBefore(currentAppointment.getEndTime())) {
					System.out.println("kom hit");
					// check to see if both apointmentstart and apointmentend is within range
					if (appointment.getStartTime().isAfter(currentAppointment.getStartTime()) && appointment.getEndTime().isBefore(currentAppointment.getEndTime())) {
						//Check if employe is the same
						if (appointment.getEmploye().getEmployeNr() == currentAppointment.getEmploye().getEmployeNr()) {
							return false;	
						}
					}
				}
			}*/
		}
		return true;
	}
}

