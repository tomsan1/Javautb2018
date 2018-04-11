package java1;

import java.time.ZoneOffset;
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
			
			//Case Employe is the same
			if (currentAppointment.employe.getEmployeNr() == appointment.employe.getEmployeNr()) {
				//Case 1 if currentAppointment.starttime --->  appointment.starttime ------> currentAppointment.endtime
				if (currentAppointment.getStartTime().isBefore(appointment.getStartTime()) && currentAppointment.getEndTime().isAfter(appointment.getStartTime())) {
					return false;
				}
				//Case 2 if currentappointment.starttime ---> appointment.endtime -------> currentAppointment.endtime
				if (currentAppointment.getStartTime().isBefore(appointment.getEndTime()) && currentAppointment.getEndTime().isAfter(appointment.getEndTime())) {
					return false;
				}
				
				//Case 3 if appointment.starttime -------> currentappointment.starttime --------> appointment.endtime && 
				//appointment.starttime ------> currentappointment.endtime -------> appointment.endtime
				if (appointment.getStartTime().isBefore(currentAppointment.getStartTime()) && appointment.getEndTime().isAfter(currentAppointment.getStartTime())) {
					if (appointment.getStartTime().isBefore(currentAppointment.getEndTime()) && appointment.getEndTime().isAfter(currentAppointment.getEndTime())){
						return false;
					}
				}
				//May be redundant.... but will keep anyway
				//Case 4 if currentappointment.starttime ------> appointment.starttime && currentappointment.endtime -------> appointment.endtime
				if (currentAppointment.getStartTime().isBefore(appointment.getStartTime()) && currentAppointment.getEndTime().isAfter(appointment.getEndTime())) {
					System.out.println("Case4");
					return false;
				}
				//Case 5 if currentappointment.starttime == appointment.starttime && currentappointment.endtimme == appointment.endtime
				if (currentAppointment.getStartTime().isEqual(appointment.getStartTime()) && currentAppointment.getEndTime().isEqual(appointment.getEndTime())) {
					return false;
				}
			}
		}
		return true;
	}
}

