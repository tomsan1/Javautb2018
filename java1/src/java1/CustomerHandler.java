package java1;

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
	

}

