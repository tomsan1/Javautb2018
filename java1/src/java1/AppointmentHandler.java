package java1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AppointmentHandler {
	
	ArrayList<Appointment> ap = new ArrayList<>();
	
	public void printOutAppointments() {
		
		for(Appointment currentAppointment : ap){
			System.out.println("---------------------------------");
			System.out.println("Kund:" + currentAppointment.customer.getFname() + " " + currentAppointment.customer.getLName());
			System.out.println("Frisör:" + currentAppointment.employe.getFname() + " " + currentAppointment.employe.getLName());
			System.out.println("Start:" + currentAppointment.getStartTime().toString());
			System.out.println("Slut:" + currentAppointment.getEndTime().toString());
			System.out.println("---------------------------------");	
		}		
	}
	
	public boolean insertAppointment(Appointment appointment) {
		
		//Checks if the appointment is ok then inserts it to the array
		if (isAvalible(appointment)) {
			
			if (isValid(appointment)) {
				
				ap.add(appointment);
				return true;
			}
		}
			
		return false;	
	}
	
	public void removeAppointment(Appointment appointment) {
		//Create code for this will need some id in the Appointmentclass
	}
	
	private boolean isValid(Appointment appointment) {
		
		//Will add more conditions here 
		if (appointment.getStartTime().isBefore(LocalDateTime.now())) {
			System.out.println("Du försöker skapa en bokning före idag pucko");
			return false;
		}
		
		return true;
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
	
	
	public void writeAppointmentsToFile() throws IOException {
		
		FileWriter fw = new FileWriter(new File("appointments.txt"));
		fw.write(("Hårdkodat input "));
		fw.close();
		
	}
	
}

