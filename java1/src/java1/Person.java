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
		if (myElevator.isDoorOpen()) {
			//System.out.println(this.getName() + " går in i hissen");
			this.isInElevator = true;
			//System.out.println(this.getName() + " trycker på knappen för våning:" + this.desieredFloor);
			synchronized(myElevator) {
				myElevator.pushButton((Integer)this.desieredFloor);
			}
			
		}
	}
	public void exitElevator() {
		if (myElevator.isDoorOpen()) {
			this.isInElevator = false;
			this.currentFloor = this.getDesieredFloor();
			//System.out.print(this.getName() + " kliver av hissen");
		}
	}
	public boolean isInElevator() {
		return isInElevator;	
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
					
					//check if elevator is at this floor and get into the elevator...
					if (myElevator.getCurFloor() == this.getCurrentFloor() && ! this.isInElevator) {
						enterElevator();
					}
					else {
						//Thread.sleep(3000);
						if (! this.isInElevator) {
							
							//Put code here to check what persons that are waiting for elevator		
						}
					}
					// Person is on the desiered floor get out of elevator...
					if ((myElevator.getCurFloor() == this.getDesieredFloor() &&  this.isInElevator)) {
						exitElevator();
					}
				}
				else {
					//get random decision if i want to go for elevatorride
					Thread.sleep(8000);
					// do i want to go to a different floor? 
					boolean wantToGoToAnotherFloor = myRandGen.nextBoolean();
					if (wantToGoToAnotherFloor) {
						// Hardcoded number of floors (5) needs to be fixed
						while (this.desieredFloor == this.currentFloor ) {
							desieredFloor = myRandGen.nextInt(myElevator.getNoOfFloors());
						}
						// get random desieredfloor
						// pushbutton to get elevator to this floor or get in if it is allready here.
						if (myElevator.getCurFloor() == this.getCurrentFloor()) {
							enterElevator();
							myElevator.pushButton(this.getDesieredFloor());
						}
						else {
							// check that pushButton does not contain this floor already....
							synchronized(myElevator) {
								myElevator.removePushedButtons(this.currentFloor);
								myElevator.pushButton(this.currentFloor);
							}
							
						}
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
