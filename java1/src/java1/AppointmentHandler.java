package java1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
			System.out.println("Uppskattat pris:" + currentAppointment.getEstPrice());
			System.out.println("---------------------------------");	
		}		
	}
	
	public Appointment getAppointmentForTesting() {
		//This is strictly used for testing purpose
		return ap.get(0);
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
	
	public boolean isValid(Appointment appointment) {
		
		//Will add more conditions here 
		if (appointment.getStartTime().isBefore(LocalDateTime.now())) {
			System.out.println("Du försöker skapa en bokning före aktuellt datum var vänlig köp en tidsmaskin");
			return false;
		}
		if (appointment.getEmploye() == null) {
			return false;
		}
		if (appointment.getCustomer() == null) {
			return false;
		}
		
		return true;
	}
	
	public boolean isAvalible(Appointment appointment) {
		
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
	
	
	public void saveToFile(String fileName) {
			
			try {
				FileWriter fw = new FileWriter(new File(fileName));
				for (Appointment currApp : ap) {
				
					fw.write(currApp.getEmploye().getEmployeNr() + "," + currApp.getCustomer().getCustNumber() + "," + currApp.getStartTime().getYear() + "," + currApp.getStartTime().getMonthValue()
					+ "," + currApp.getStartTime().getDayOfMonth() + ","  + currApp.getStartTime().getHour() + "," + currApp.getStartTime().getMinute()
					+  "," + currApp.getEndTime().getYear() + "," + currApp.getEndTime().getMonthValue() + "," + currApp.getEndTime().getDayOfMonth()   
					+ "," + currApp.getEndTime().getHour() + "," + currApp.getEndTime().getMinute()+"\n");
				}
				fw.close();
			}
			catch (IOException e) {
				ErrorHandler myErrHand = new ErrorHandler();
				myErrHand.errorHasOccured(e, "Ett fel uppstod vid sparande av Anstdatabas");	
			}
	}
	
	
	
	public void readFromFile(EmployeHandler myEmpHandler, CustomerHandler myCustHandler, String fileName) throws IOException {
		
		BufferedReader input;
		
		try {
			input = new BufferedReader(new FileReader(new File(fileName)));
		}
		catch (FileNotFoundException e) {
			System.out.println("Filen på appointments hittades ej");
			return;
		}
		
		int fieldnr = 1;
		String curStringContent = "";
		int custNumber = 0;
		int empNumber = 0;
		int startYear = 0;
		int startMonth = 0;
		int startDay = 0;
		int startHour = 0;
		int StartMinute = 0;
		
		int endYear = 0;
		int endMonth = 0;
		int endDay = 0;
		int endHour = 0;
		int endMinute = 0;
		
		
		while (input.ready()) {
			char curChar = (char)input.read();
			
			if (curChar != ',') {
				curStringContent = curStringContent + curChar;
			}
			else {
				
				if (fieldnr == 1) {
					empNumber = Integer.parseInt(curStringContent);
					curStringContent = "";
				}
				if (fieldnr == 2) {
					custNumber = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 3) {
					startYear = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 4) {
					startMonth = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				
				if (fieldnr == 5) {
					startDay = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if  (fieldnr == 6) {
					startHour = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 7) {
					StartMinute = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 8) {
					endYear = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 9) {
					endMonth = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 10) {
					 endDay = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 11) {
					endHour = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				if (fieldnr == 12) {
					endMinute = Integer.parseInt(curStringContent);
					curStringContent = "";	
				}
				
				fieldnr++;
			}
			//linechange in file indicates new appointment
			if (curChar == '\n') {
				//Removes \n char at the end...
				endMinute = Integer.parseInt(curStringContent.substring(0, (curStringContent.length()-1)));
				curStringContent = "";
				fieldnr = 1;
			
				Appointment aApp = new Appointment();
				Employe aEmp =  myEmpHandler.getEmploye(custNumber);
				Customer aCust = myCustHandler.getCustomer(custNumber);
				LocalDateTime startTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, StartMinute);
				LocalDateTime endTime = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute);
				
				aApp.setCustomer(aCust);
				aApp.setEmploye(aEmp);
				aApp.setStartTime(startTime);
				aApp.setEndTime(endTime);
					
				insertAppointment(aApp);
				
			}	
		}
	}
	
}

