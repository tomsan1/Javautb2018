package java1;

public class UserInterface implements Runnable {

	Person pers1;
	Person pers2;
	Person pers3;
	Person pers4;
	Elevator elev1;
	
	public UserInterface(Person p1, Person p2, Person p3, Person p4, Elevator e1) {
		pers1 = p1;
		pers2 = p2;
		pers3 = p3;
		pers4 = p4;
		elev1 = e1;
		
	}
	
	public void printStateOfElevator() {
		
		// print a bunch of empty lines to clear screen... must be a better way....
		
		
		
		
		for (int floor = 0; floor < elev1.getNoOfFloors(); floor++ ) {
				
			String personsInElevator = "";
			String personsOutsideElevator = "";
			String someOnePushed = "";
			
			
			System.out.println("------------------------------------");
			System.out.println(floor);
			System.out.println("------------------------------------");
						
			
			
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

