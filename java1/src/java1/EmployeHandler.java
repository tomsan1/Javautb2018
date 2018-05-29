package java1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	public void saveToFile(String fileName) {
		
		
		try {
			FileWriter fw = new FileWriter(new File(fileName));
			for (Employe currEmp : eh) {
				
				fw.write(currEmp.getEmployeNr() + "," + currEmp.getFname() + "," + currEmp.getLName() + "\n");
				
			}
			fw.close();
		}
		catch (IOException e) {
			ErrorHandler myErrHand = new ErrorHandler();
			myErrHand.errorHasOccured(e, "Ett fel uppstod vid sparande av Anstdatabas");	
		}
	}
	
	public void readFromFile(String fileName) throws IOException {
		
		BufferedReader input;
		try {
			input = new BufferedReader(new FileReader(new File(fileName)));
		}
		catch (FileNotFoundException e) {
			System.out.println("Filen på anställda hittades ej");
			return;
		}
		
		
		int fieldnr = 1;
		String curStringContent = "";
		int empNumber = 0;
		String empFname = "";
		String empLname = "";
		
		
		while (input.ready()) {
			char curChar = (char)input.read();
			
			if (curChar != ',') {
				curStringContent = curStringContent + curChar;
			}
			else {
				//Assign employenumber
				if (fieldnr == 1) {
					empNumber = Integer.parseInt(curStringContent);
					curStringContent = "";
				}
				else if (fieldnr == 2) {
					empFname = curStringContent;
					curStringContent = "";	
				}
				fieldnr++;
			}
			//linechange in file indicates new customer
			if (curChar == '\n') {
		
				empLname = curStringContent.substring(0, (curStringContent.length()-1));
				curStringContent = "";
				fieldnr = 1;
				Employe aEmp = new Employe();
				aEmp.setEmployeNr(empNumber);
				aEmp.setFName(empFname);
				aEmp.setLName(empLname);
				addEmploye(aEmp);
				
			}	
		}
		input.close();
	}
		
}
