package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class UserInterface {
	
	AppointmentHandler myAppHandler = new AppointmentHandler();
	CustomerHandler myCustHandler = new CustomerHandler();
	EmployeHandler myEmpHandler = new EmployeHandler();
	
	public void printMenu() {
		System.out.println("-------------Meny-----------");
		System.out.println("1. Ny bokning ");
		System.out.println("2. Visa bokningar ");
		System.out.println("3. Visa dagens bokningar ");
		System.out.println("4. Skapa ny kund");
		System.out.println("5. Visa alla kunder");
		System.out.println("6. Skapa ny anställd");
		System.out.println("7. Visa alla anställda");
		System.out.println("8. test");
		System.out.println("----------------------------");
		
	}
	
	public void runMenu() throws NumberFormatException, IOException {
		
		
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
				
				case 4: Customer myCust = createCustomer();
						myCustHandler.addCustomer(myCust);
						break;
				
				case 5: myCustHandler.printAllCustomers();
						break;
						
				case 6: Employe myEmp = createEmploye();
						myEmpHandler.addEmploye(myEmp);
				
				case 7: myEmpHandler.printAllEmployes();
						break;
				case 8: System.out.println(myEmpHandler.getFirstAvalibleEmpNr());
						break;
			}
		}
	}
	
	public void addAppointment() throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Input for date and time
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
		
		//Input for employe and customer
		System.out.println("Ange Anställdnr:");
		int empNr = Integer.parseInt(input.readLine());
		System.out.println("Ange Kundnr:");
		int custNr = Integer.parseInt(input.readLine());
		
		
		
		//Creating new appointment with cust and emp
		Appointment myApp = new Appointment();
		
		myApp.setCustomer(myCustHandler.getCustomer(custNr));
		myApp.setEmploye(myEmpHandler.getEmploye(empNr));
		
		
		myApp.setStartTime(LocalDateTime.of(year, month, day, hour, minute));
		myApp.setEndTime(LocalDateTime.of(year, month, day, hour, minute).plusMinutes(duration));
		
		
		boolean result = myAppHandler.insertAppointment(myApp);
		if (result) {
			System.out.println("Bokning genomfördes");
		}
		else {
			System.out.println("Bokning ej möjlig det finns konflikter");
		}
	}
	
	public Customer createCustomer() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		Customer newCust = new Customer();
		System.out.print("Förnamn:");
		newCust.setFName(input.readLine());
		System.out.print("Efternamn:");
		newCust.setLName(input.readLine());
		
		newCust.setCustNumber(myCustHandler.getFirstAvalibleCustNr());
		return newCust;
		
	}

	public Employe createEmploye() throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		Employe newEmp = new Employe();
		System.out.print("Förnamn:");
		newEmp.setFName(input.readLine());
		System.out.print("Efternamn:");
		newEmp.setLName(input.readLine());
		newEmp.setEmployeNr(myEmpHandler.getFirstAvalibleEmpNr());
		return newEmp;
		
	}
	
}
