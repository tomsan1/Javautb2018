package java1;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Person> outOfElevPersons = new ArrayList<>();
		Elevator elev1 = new Elevator(5, 0);
		Person person1 = new Person("Kalle", 95, 1);
		Person person2 = new Person("Stina", 295, 2);
		Person person3 = new Person("Elsa", 45, 2);
		Person person4 = new Person("Bengt", 95, 3);
		
		System.out.println("hissen �r nu p� v�n:" + elev1.getCurFloor());
		Thread myThread1 = new Thread(person1);
		myThread1.start();
		
		
		
		
				
	}
	

}
