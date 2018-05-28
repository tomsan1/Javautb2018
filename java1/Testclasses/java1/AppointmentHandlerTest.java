package java1;

import static org.junit.Assert.*;

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
	public void TestToMakeAppointmentBeforeCurrentDateShouldReturnFalse() {
		
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
	public void TestToMakeAppointmentWithStartTimeWithinOtherAppointmentShouldReturnFalse() {
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
	public void TestToMakeAppointmentWithEndTimeWithinOtherAppointmentShouldReturnFalse() {
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
	public void TestToMakeAppointmentWithAnotherAppointmentWithinAppointmentToCreate() {
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
	public void TestToMakeAppointmentWithinAnotherAppointment() {
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
	public void TestToMakeAppointmentWhenEverythingIsOkShouldReturnTrue() {
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
	public void TestToMakeAppointmentWhenEverythingIsOkButWhenAnotherappointmentExixstWithAnotherHairdresserShouldReturnTrue() {
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
}
