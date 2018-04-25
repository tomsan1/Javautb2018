package java1;

import java.util.Random;

public class Person implements Runnable {
	private int weight;
	private int gender; //1=male 2=female 3=other
	private String name;
	private int currentFloor;
	private int desieredFloor;
	private Elevator myElevator; 
	private boolean isInElevator;
	
	public Person(String n, int w, int g, Elevator e) {
		this.weight = w;
		this.gender = g;
		this.name = n;
		this.currentFloor = 0;
		this.myElevator = e;
		this.isInElevator = false;
	}
	
	public void setDesieredFloor(int d) {
		this.desieredFloor = d;
	}
	public int getDesieredFloor() {
		return this.desieredFloor;
	}
	public String getName() {
		return this.name;
	}
	public void setCurrentFloor(int c) {
		this.currentFloor = c;
	}
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	public void enterElevator() {
		
		//myElevator.enterElevator(this);
		System.out.println(this.getName() + " går in i hissen som är på våning: " + myElevator.getCurFloor() );
		this.isInElevator = true;
		System.out.println(this.getName() + " trycker på knappen för våning:" + this.desieredFloor);
		myElevator.pushButton((Integer)this.desieredFloor);
	}
	public void exitElevator() {
		this.isInElevator = false;
		this.currentFloor = this.getDesieredFloor();
		System.out.println("------------------------------------");
		System.out.println(this.getName() + " kliver av hissen");
		System.out.println("------------------------------------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			//never end the thread/Make it possible for the person to always make new decisions
			//Decide where I want to go or decide if I should go in or out of the elevator
			Random myRandGen = new Random();
			try {
				// am i on the floor that i want to be?
				if (desieredFloor != currentFloor) { // i am on the wrong floor....
					
					//check if elevator is at this floor
					if (myElevator.getCurFloor() == this.getCurrentFloor() && ! this.isInElevator) {
						enterElevator();
					}
					else {
						Thread.sleep(100);
						if (! this.isInElevator) {
							System.out.println(this.getName() + " väntar på hissen på våning: " + this.getCurrentFloor() + " för att åka till våning:" + this.getDesieredFloor() );
							
						}
					}
					if ((myElevator.getCurFloor() == this.getDesieredFloor() &&  this.isInElevator)) {
						exitElevator();
					}
					
				}
				else {
							
					//get random decision if i want to go for elevatorride
				
					Thread.sleep(2000);
					// do i want to go to a diffrent floor? 
					boolean wantToGoToAnotherFloor = myRandGen.nextBoolean();
					if (wantToGoToAnotherFloor) {
						
						
						// Hardcoded number of floors (5) needs to be fixed
						while (this.desieredFloor == this.currentFloor ) {
							desieredFloor = myRandGen.nextInt(5);
						}
						System.out.println(this.getName() + " har bestämt sig för att åka till våning:" + this.desieredFloor);
						// get random desieredfloor
						// pushbutton to get elevator to this floor
						System.out.println(this.getName() + " trycker på knappen för att få hissen till våning:" + this.currentFloor);
						if (myElevator.getCurFloor() == this.getCurrentFloor()) {
							enterElevator();
							myElevator.pushButton(this.getDesieredFloor());
						}
						else {
							System.out.println(this.getName() + " trycker på knappen för att få hissen till våning:" + this.currentFloor);
							myElevator.pushButton(this.currentFloor);
						}
							
					}
				}
				
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
