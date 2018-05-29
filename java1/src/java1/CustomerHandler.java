package java1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CustomerHandler {
	
	ArrayList<Customer> ch = new ArrayList<>();
	
	public void addCustomer(Customer newCust) {
		ch.add(newCust);
	}
	
	public Customer getCustomer(int custnr) {
		
		for (Customer currentCustomer : ch) {
			if (currentCustomer.getCustNumber() == custnr)
				return currentCustomer;
		}
		System.out.println("Hittade ingen kund");
		
		//Will fix this so it does not return null if no customer is found
		return null;
		
		
	}
	
	public void printAllCustomers() {
		
		for (Customer cCustomer : ch) {
			System.out.println(cCustomer.getCustNumber() + " " + cCustomer.getFname() + " " + cCustomer.getLName());
		}
			
	}
	
	public int getFirstAvalibleCustNr() {
		
		//Not a good soloution....
		return ch.size()+1;
	}
	public void saveToFile(String fileName) {
		
		
		try {
			FileWriter fw = new FileWriter(new File(fileName));
			for (Customer currCust : ch) {
				
				fw.write(currCust.getCustNumber() + "," + currCust.getFname() + "," + currCust.getLName() + "\n");
				
			}
			fw.close();
		}
		catch (IOException e) {
			ErrorHandler myErrHand = new ErrorHandler();
			myErrHand.errorHasOccured(e, "Ett fel uppstod vid sparande av kunddatabas");	
		}
		
		
	}
	public void readFromFile(String fileName) throws IOException {
	
		BufferedReader input; 
		
		try {
			input = new BufferedReader(new FileReader(new File(fileName)));
		}
		catch (FileNotFoundException e) {
			System.out.println("Fil på kunder hittades ej");
			return;
		}
		
		
		int fieldnr = 1;
		String curStringContent = "";
		int custNumber = 0;
		String custFname = "";
		String custLname = "";
		
		
		while (input.ready()) {
			char curChar = (char)input.read();
			
			if (curChar != ',') {
				curStringContent = curStringContent + curChar;
			}
			else {
				//Assign customernumber
				if (fieldnr == 1) {
					custNumber = Integer.parseInt(curStringContent);
					curStringContent = "";
				}
				else if (fieldnr == 2) {
					custFname = curStringContent;
					curStringContent = "";	
				}
				fieldnr++;
			}
			//linechange in file indicates new customer
			if (curChar == '\n') {
				//Removes \n char at the end...
				custLname = curStringContent.substring(0, (curStringContent.length()-1));
				curStringContent = "";
				fieldnr = 1;
			
				Customer aCust = new Customer();
				aCust.setCustNumber(custNumber);
				aCust.setFName(custFname);
				aCust.setLName(custLname);
				addCustomer(aCust);				
			}	
		}
		input.close();
	}
	

}

