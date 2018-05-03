package java1;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		List<Person> myPersons = new ArrayList<>();
		Elevator elev1 = new Elevator(15, 0);
		Person person1 = new Person("Kalle", 95, 1, elev1);
		Person person2 = new Person("Stina", 295, 2, elev1);
		Person person3 = new Person("Elsa", 45, 2, elev1);
		Person person4 = new Person("Bengt", 95, 3, elev1);
		
		
		
		Person person5 = new Person("Doris", 95, 1, elev1);
		Person person6 = new Person("Aragon", 295, 2, elev1);
		Person person7 = new Person("Thor", 45, 2, elev1);
		Person person8 = new Person("Loke", 95, 3, elev1);
		
		Person person9 = new Person("Jotun", 95, 1, elev1);
		Person person10 = new Person("Qverty", 295, 2, elev1);
		Person person11 = new Person("Citron", 45, 2, elev1);
		Person person12 = new Person("Gargamel", 95, 3, elev1);
		
		myPersons.add(person1);
		myPersons.add(person2);
		myPersons.add(person3);
		myPersons.add(person4);
		myPersons.add(person5);
		myPersons.add(person6);
		myPersons.add(person7);
		myPersons.add(person8);
		myPersons.add(person9);
		myPersons.add(person10);
		myPersons.add(person11 );
		myPersons.add(person12);
		
		
	
		Thread myThread1 = new Thread(person1);
		Thread myThread2 = new Thread(person2);
		Thread myThread3 = new Thread(person3);
		Thread myThread4 = new Thread(person4);
		Thread elevThread = new Thread(elev1);
		
		Thread myThread5 = new Thread(person5);
		Thread myThread6 = new Thread(person6);
		Thread myThread7 = new Thread(person7);
		Thread myThread8 = new Thread(person8);
		
		Thread myThread9 = new Thread(person9);
		Thread myThread10 = new Thread(person10);
		Thread myThread11 = new Thread(person11);
		Thread myThread12 = new Thread(person12);
		UserInterface myUi = new UserInterface(myPersons, elev1);
		
		
			
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
		
		
		myThread5.start();
		myThread6.start();
		myThread7.start();
		myThread8.start();
		
		myThread9.start();
		myThread10.start();
		myThread11.start();
		myThread12.start();
		
		
		elevThread.start();
		myUi.run();
		
	}
}
