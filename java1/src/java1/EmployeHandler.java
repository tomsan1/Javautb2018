package java1;

import java.util.ArrayList;

public class EmployeHandler {
	ArrayList<Employe> eh = new ArrayList<>();
	
	public void addEmploye(Employe newEmp) {
		eh.add(newEmp);
	}
	
	public Employe getEmploye(int empnr) {

		for (Employe currentEmploye : eh) {
			if (currentEmploye.getEmployeNr() == empnr) 
				return currentEmploye;
		}
		System.out.println("Hittade ingen anställd");
		return null;
	}
	
	public void printAllEmployes() {
		
		for (Employe eEmploye : eh) {
			System.out.println(eEmploye.getEmployeNr() + " " + eEmploye.getFname() + " " + eEmploye.getLName());
		}		
	}
	
	public int getFirstAvalibleEmpNr() {
		
		//Must take care of this later on will not work forever
		return eh.size()+1;
	}
}
