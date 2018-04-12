package java1;

public class Employe extends Person {
	private int employeNr;
	
	public Employe(String fName, String lName, String phoneNumber, int employeNr) {
		this.setFName(fName);
		this.setLName(lName);
		this.setPhoneNumber(phoneNumber);
		this.setEmployeNr(employeNr);
	}
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public void setEmployeNr(int employeNr) {
		this.employeNr = employeNr;
		
	}
	public int getEmployeNr() {
		return this.employeNr;
	}
	
}
