package java1;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Person> outOfElevPersons = new ArrayList<>();
		Elevator elev1 = new Elevator(5, 0);
		Person person1 = new Person("Kalle", 95, 1, elev1);
		Person person2 = new Person("Stina", 295, 2, elev1);
		Person person3 = new Person("Elsa", 45, 2, elev1);
		Person person4 = new Person("Bengt", 95, 3, elev1);
		
		
		System.out.println("hissen är nu på vån:" + elev1.getCurFloor());
		Thread myThread1 = new Thread(person1);
		Thread myThread2 = new Thread(person2);
		Thread elevThread = new Thread(elev1);
		myThread1.start();
		myThread2.start();
		elevThread.start();
		
	}
}
