package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Program {

	static AppointmentHandler myAppHandler = new AppointmentHandler();
	
	public static void main(String[] args) throws IOException {
	
		
		
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			printMenu();
			int menuChoice = 0;
			menuChoice = Integer.parseInt(input.readLine());
		
			switch (menuChoice) {
				case 1: addAppointment();
						break;
			
				case 2: myAppHandler.printOutAppointments();
						break;		
			}
		}
		
	}
	
	public static void printMenu() {
		System.out.println("-------------Meny-----------");
		System.out.println("1. Ny Bokning ");
		System.out.println("2. Visa Bokningar ");
	}
	
	public static void addAppointment() throws IOException{
			
			
		
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		 	System.out.println("Ange start år yyyy:");
			int year = Integer.parseInt(input.readLine());
			System.out.println("Ange mån mm:");
			int month = Integer.parseInt(input.readLine());
			System.out.println("Ange dag dd:");
			int day = Integer.parseInt(input.readLine());
			System.out.println("Ange tim hh:");
			int hour = Integer.parseInt(input.readLine());
			System.out.println("Ange min:");
			int minute = Integer.parseInt(input.readLine());
			System.out.println("Ange tid i minuter för klippning:");
			int duration = Integer.parseInt(input.readLine());
			
			Appointment myApp = new Appointment();
			
			//hardcoded Employe will fix this later
			Employe myEmp = new Employe();
			myEmp.setEmployeNr(1);
			myEmp.setFName("Anställd");
			myEmp.setLName("Anställdson");
			//hardcoded Customer will fix this later
			Customer myCust = new Customer();
			myCust.setCustNumber(1);
			myCust.setFName("Kund");
			myCust.setLName("Kundsson");
			
			myApp.setCustomer(myCust);
			myApp.setEmploye(myEmp);
			LocalDateTime startTime = LocalDateTime.of(year, month, day, hour, minute);
			LocalDateTime endTime = startTime.plusMinutes(duration);
			
			myApp.setStartTime(startTime);
			myApp.setEndTime(endTime);
			
			boolean result = myAppHandler.insertAppointment(myApp);
			if (result) {
				System.out.println("Bokning genomfördes");
			}
			else {
				System.out.println("Bokning ej möjlig det finns konflikter");
			}
	}
}
