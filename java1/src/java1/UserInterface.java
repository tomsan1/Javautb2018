package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import org.json.JSONException;

public class UserInterface {
	
	AppointmentHandler myAppHandler = new AppointmentHandler();
	CustomerHandler myCustHandler = new CustomerHandler();
	EmployeHandler myEmpHandler = new EmployeHandler();
	ErrorHandler myErrHandler = new ErrorHandler();
	
	public void printMenu() {
		System.out.println("-------------Meny-----------");
		System.out.println("1. Ny bokning ");
		System.out.println("2. Visa bokningar ");
		System.out.println("3. H�mta data fr�n fil ");
		System.out.println("4. Skapa ny kund");
		System.out.println("5. Visa alla kunder");
		System.out.println("6. Skapa ny anst�lld");
		System.out.println("7. Visa alla anst�llda");
		System.out.println("8. Spara data till fil");
		System.out.println("9. Avsluta");
		System.out.println("----------------------------");
		
	}
	
	public void runMenu() throws NumberFormatException, IOException, JSONException {
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean runMenu = true;
		while (runMenu) {
		printMenu();
			
			int menuChoice = 0;
			try{
				menuChoice = Integer.parseInt(input.readLine());
			}
			catch (NumberFormatException e){
				myErrHandler.errorHasOccured(e, "Otill�tet menyval v�nligen ange siffra som motsvarar menyvalet");
				continue;
			}
		
			switch (menuChoice) {
				case 1: addAppointment();
						break;
			
				case 2: myAppHandler.printOutAppointments();
						break;		
				case 3: myCustHandler.readFromFile();
						myEmpHandler.readFromFile();
						myAppHandler.readFromFile(myEmpHandler, myCustHandler);
						break;
				
				case 4: Customer myCust = createCustomer();
						myCustHandler.addCustomer(myCust);
						break;
				
				case 5: myCustHandler.printAllCustomers();
						break;
						
				case 6: Employe myEmp = createEmploye();
						myEmpHandler.addEmploye(myEmp);
						break;
				
				case 7: myEmpHandler.printAllEmployes();
						break;
						
				case 8: myCustHandler.saveToFile();
						myEmpHandler.saveToFile();
						myAppHandler.saveToFile();
						break;
				
				case 9: System.out.println("Avslutar programmet");
						runMenu = false;
						break;
			}
		}
	}
	
	public void addAppointment() throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 	
		//Input for date and time
		
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int duration = 0;
		
		try {
			System.out.println("Ange �r yyyy:");
			year = Integer.parseInt(input.readLine());
			if (year < 2018 || year > 2030) {
				throw new DateOutOfBoundsException("�rtal m�ste vara mellan 2018-2030");
			}
		
			System.out.println("Ange m�n mm:");
			month = Integer.parseInt(input.readLine());
			if (month < 1 || month > 12) {
				throw new DateOutOfBoundsException("M�nad m�ste vara mellan 1-12");
			}
		
			
			System.out.println("Ange dag dd:");
			day = Integer.parseInt(input.readLine());
			if (day < 1 || day > 31) {
				throw new DateOutOfBoundsException("Dag m�ste vara mellan 1-31");
			}
			
			//Needs to be able to state openinghours
			System.out.println("Ange tim hh:");
			hour = Integer.parseInt(input.readLine());
			if (hour < 0 || hour > 24) {
				throw new DateOutOfBoundsException("Timmar m�ste vara mellan 0-24");
			}
				
			System.out.println("Ange min:");
			minute = Integer.parseInt(input.readLine());
			if (minute < 0 || minute > 60) {
				throw new DateOutOfBoundsException("Minuter m�ste vara mellan 0-60");
			}
			
			
			System.out.println("Ange tid i minuter f�r klippning:");
			duration = Integer.parseInt(input.readLine());
			if (duration < 0 || duration > 480) {
				throw new DateOutOfBoundsException("tid f�r klippning m�ste vara mellan 0-480 minuter");
			}
				
			
		}
		
		catch (NumberFormatException e) {
			myErrHandler.errorHasOccured(e, "Fel i datumformat bokning avbryts");
			return;
		}
		catch (DateOutOfBoundsException e) {
			myErrHandler.errorHasOccured(e, "Fel i datumstr�ng bokning avbryts");
			return;
		}
		
		
		//Input for employe and customer
		int empNr = 0;
		int custNr = 0;
		System.out.println("Ange Anst�lldnr:");
		try {
			empNr = Integer.parseInt(input.readLine());
			if (myEmpHandler.getEmploye(empNr) == null) {
				System.out.println("Anst�lld saknas f�r angivet anst�llningsnummer bokningen avbryts");
				return;
			}
		}
		catch (NumberFormatException e) {
			myErrHandler.errorHasOccured(e, "Endast siffror till�tna i anst�llningsnummer bokningen avbryts");
			return;
		}
		
		
	
		
		System.out.println("Ange Kundnr:");
		try {
			custNr = Integer.parseInt(input.readLine());
			if (myCustHandler.getCustomer(custNr) == null) {
				System.out.println("Kund saknas f�r angivet kundnummer bokning avbryts");
				return;
			}
		}
		catch (NumberFormatException e) {
			myErrHandler.errorHasOccured(e, "Endast siffror till�tna i kundnummer bokningen avbryts");
			return;
			
		}
			
		
		
		
		//Creating new appointment with cust and emp
		Appointment myApp = new Appointment();
		
		myApp.setCustomer(myCustHandler.getCustomer(custNr));
		myApp.setEmploye(myEmpHandler.getEmploye(empNr));
		
		
		myApp.setStartTime(LocalDateTime.of(year, month, day, hour, minute));
		myApp.setEndTime(LocalDateTime.of(year, month, day, hour, minute).plusMinutes(duration));
		
		
		boolean result = myAppHandler.insertAppointment(myApp);
		if (result) {
			System.out.println("Bokning genomf�rdes");
		}
		else {
			System.out.println("Bokning ej m�jlig det finns konflikter");
		}
	}
	
	public Customer createCustomer() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		Customer newCust = new Customer();
		System.out.print("F�rnamn:");
		String fname = input.readLine();
		while (fname.isEmpty()) {
			System.out.println("F�rnamn kr�vs");
			System.out.print("F�rnamn:");
			fname = input.readLine();
		}
		newCust.setFName(fname);
	
		System.out.print("Efternamn:");
		String lname = input.readLine();
		while (lname.isEmpty()) {
			System.out.println("Efternamn kr�vs");
			System.out.print("Efternamn:");
			lname = input.readLine();
		}
		
		newCust.setLName(lname);
		newCust.setCustNumber(myCustHandler.getFirstAvalibleCustNr());
		return newCust;
		
	}

	public Employe createEmploye() throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		Employe newEmp = new Employe();
		System.out.print("F�rnamn:");
		String fname = input.readLine();
		while (fname.isEmpty()) {
			System.out.println("F�rnamn kr�vs");
			System.out.println("F�rnamn:");
			fname = input.readLine();
		}
		newEmp.setFName(fname);
		System.out.print("Efternamn:");
		String lname = input.readLine();
		while (lname.isEmpty()) {
			System.out.println("Efternamn kr�vs");
			System.out.println("Efternamn:");
			lname = input.readLine();
		}
		newEmp.setLName(lname);
		newEmp.setEmployeNr(myEmpHandler.getFirstAvalibleEmpNr());
		return newEmp;
		
	}
	
}
