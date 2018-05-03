package java1;

import java.util.ArrayList;
import java.util.List;

public class UserInterface implements Runnable {

	Elevator elev1;
	List<Person> persons;
	
	public UserInterface(List p, Elevator e1) {
		
		elev1 = e1;
		persons = p;
		
	}
	
	public void printStateOfElevator() {
		
		// print a bunch of empty lines to clear screen... must be a better way....
		
		
		
		
		for (int floor = 0; floor < elev1.getNoOfFloors(); floor++ ) {
				
			String personsInElevator = "";
			
			String someOnePushed = "";
			
			for (Person cP : persons) {
				//for persons inside elevator
				if (cP.isInElevator())
					personsInElevator = personsInElevator + ", " + cP.getName().substring(0, 1);
			}
			//printing elevator
			if (elev1.getCurFloor() == floor) {
				System.out.println("------------------------------------");
				System.out.print(floor + " ");
				for (Person cP : persons) {
					if (cP.getCurrentFloor() == floor && ! cP.isInElevator()) {
						System.out.print(cP.getName().substring(0, 1) + ", ");
					}
				}
				System.out.println(" | " + personsInElevator + " |");
				System.out.println("------------------------------------");
				personsInElevator = "";
					
			}
			else {
				System.out.println("------------------------------------");
				System.out.print(floor + " ");
				for (Person cP : persons) {
					if (cP.getCurrentFloor() == floor && ! cP.isInElevator()) {
						System.out.print(cP.getName().substring(0, 1) + ", ");
					}
					
				}
				System.out.println("------------------------------------");
				
			}
			
						
			
			
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
			
				
		
		
		
		
	}
	
	
	
	
	@Override
	public void run() {
		
		while (true) {
			printStateOfElevator();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

