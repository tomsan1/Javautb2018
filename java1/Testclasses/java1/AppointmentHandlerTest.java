package java1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class AppointmentHandlerTest {
	AppointmentHandler myAppHandler;
	@Before
	public void setUp() {
		
		myAppHandler = new AppointmentHandler();
		
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment app1 = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(1);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(5);

		app1.setStartTime(startTime);
		app1.setEndTime(endTime);
		app1.setCustomer(aCust);
		app1.setEmploye(aEmp);
		
		myAppHandler.insertAppointment(app1);
		
	}
	
	@Test
	public void TestToMakeAppointment1ShouldReturnFalse() {
		//Testing to add appointment before current date 
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.minusDays(1);
		endTime= endTime.minusDays(1);
		endTime = endTime.plusHours(2);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);
		assertEquals(false, myAppHandler.isValid(appToAdd));
			
	}
	
	@Test 
	public void TestToMakeAppointment2ShouldReturnFalse() {
		//Testing to add appointment with starttime within an existing appointment
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(5);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);
		assertEquals(false, myAppHandler.isAvalible(appToAdd));
	}
	@Test 
	public void TestToMakeAppointment3ShouldReturnFalse() {
		//Testing to add appointment with endtime within an existing appointment
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(2);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);		
		assertEquals(false, myAppHandler.isAvalible(appToAdd));
	}
	@Test 
	public void TestToMakeAppointment4ShouldReturnFalse() {
		//Testing to add appointment with another appointment within the appointment to create
		
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(7);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);		
		assertEquals(false, myAppHandler.isAvalible(appToAdd));
			
	}
	@Test 
	public void TestToMakeAppointment5ShouldReturnFalse() {
		//Testing to add appointment whitin a existing appointment
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(3);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);		
		assertEquals(false, myAppHandler.isAvalible(appToAdd));
	}
	@Test
	public void TestToMakeAppointment6() {
		//Testing to add appointment when everything is ok 
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(1);
		aEmp.setFName("EmpFname");
		aEmp.setLName("EmpLname");
		
		aCust.setCustNumber(1);
		aCust.setFName("CustFname");
		aCust.setLName("CustLname");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(3);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(3);
		endTime = endTime.plusHours(3);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);		
		assertEquals(true, myAppHandler.isAvalible(appToAdd));
	}
	@Test 
	public void TestToMakeAppointment7ShouldReturnTrue() {
		//Testing to add appointment when everything is ok but 
		//another appointment exist with another hairdresser
		Employe aEmp     = new Employe();
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(2);
		aEmp.setFName("EmpFname2");
		aEmp.setLName("EmpLname2");
		
		aCust.setCustNumber(2);
		aCust.setFName("CustFname2");
		aCust.setLName("CustLname2");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(3);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
		appToAdd.setEmploye(aEmp);		
		assertEquals(true, myAppHandler.isAvalible(appToAdd));
	}
	@Test
	public void TestToMakeAppointmentWithoutEmployeSholdReturnFalse() {
		
		Customer aCust   = new Customer();
		Appointment appToAdd = new Appointment();
		
		aCust.setCustNumber(2);
		aCust.setFName("CustFname2");
		aCust.setLName("CustLname2");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(3);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setCustomer(aCust);
			
		assertEquals(false, myAppHandler.isValid(appToAdd));
	}
	@Test
	public void TestToMakeAppointmentWhenCustomerIsNullShouldReturnFalse() {
		Employe aEmp     = new Employe();
		
		Appointment appToAdd = new Appointment();
		
		aEmp.setEmployeNr(2);
		aEmp.setFName("EmpFname2");
		aEmp.setLName("EmpLname2");
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		
		startTime = startTime.plusDays(1);
		startTime = startTime.plusHours(2);
		endTime= endTime.plusDays(1);
		endTime = endTime.plusHours(3);

		appToAdd.setStartTime(startTime);
		appToAdd.setEndTime(endTime);
		appToAdd.setEmploye(aEmp);		
		assertEquals(false, myAppHandler.isValid(appToAdd));
	}
	@Test
	public void TestToSaveAppointmentsCustomersAndEmployesToFileShouldReturnTrue() throws IOException, InterruptedException {
		myAppHandler.saveToFile("c:\\TestAppointments.txt");
		EmployeHandler myEmpHandler = new EmployeHandler();
		myEmpHandler.addEmploye(myAppHandler.getAppointmentForTesting().getEmploye());
		CustomerHandler myCustHandler = new CustomerHandler();
		myCustHandler.addCustomer(myAppHandler.getAppointmentForTesting().getCustomer());
		
		myEmpHandler.saveToFile("c:\\TestEmployes.txt");
		myCustHandler.saveToFile("c:\\TestCustomers.txt");
		
		myAppHandler = new AppointmentHandler();
		myEmpHandler = new EmployeHandler();
		myCustHandler = new CustomerHandler();
		
		myEmpHandler.readFromFile("c:\\TestEmployes.txt");
		myCustHandler.readFromFile("c:\\TestCustomers.txt");
		myAppHandler.readFromFile(myEmpHandler, myCustHandler, "c:\\TestAppointments.txt");
		
		
		
		assertEquals("EmpFname", myAppHandler.getAppointmentForTesting().getEmploye().getFname());
		assertEquals("CustFname", myAppHandler.getAppointmentForTesting().getCustomer().getFname());
		//More checks if needed..
		
		File aFile = new File("c:\\TestAppointments.txt");
		aFile.delete();
		aFile = new File("c:\\TestCustomers.txt");
		aFile.delete();
		aFile = new File("c:\\TestEmployes.txt");
		aFile.delete();
		
		
		
	}
}
