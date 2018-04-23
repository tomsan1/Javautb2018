package java1;

import java.util.ArrayList;


public class Elevator {
	private int topFloor;
	private int bottomFloor;
	private int curFloor;
	private boolean doorClosed;
	private ArrayList<Integer> buttonsPushed;
	private ArrayList<Person> persons;
	
	public Elevator (int topF, int bottomF) {
		//Create new elevator and put it on bottomfloor and close door.
		this.topFloor = topF;
		this.bottomFloor = bottomF;
		this.curFloor = this.bottomFloor;
		doorClosed = true;
		this.buttonsPushed = new ArrayList<Integer>();
		this.persons = new ArrayList<Person>();
	}
	
	public void  openDoor()  {
		System.out.println("Dörren börjar öppnas");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.doorClosed = false;
		System.out.println("Dörren helt öppen");
	}
	public void closeDoor()  {
		System.out.println("Dörren börjar stängas");
		//Delay here 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.doorClosed = true;
		System.out.println("Dörren helt stängd");
	}
	
	public boolean isDoorOpen() {
		if (doorClosed) {
			return false;
		}
		return true;
	}
	public boolean isDoorClosed() {
		if (doorClosed) {
			return true;
		}
		return false;
	}
	
	public int getCurFloor() {
		return this.curFloor;
	}
	
	public void moveElevator(int destFloor) {
		//closeDoor();
		if (isDoorClosed()) {
			while (destFloor != curFloor) {
				if (destFloor < curFloor) {
					System.out.println("Åker ner");
					moveDownOneFloor();
				}
				if (destFloor > curFloor) {
					System.out.println("Åker upp");
					moveUpOneFloor();
				}
			}
		}
		else {
			System.out.println("Inte möjligt att flytta hissen när dörr är öppen");
		}
		
	}
	
	private void moveUpOneFloor()  {
		System.out.println("Hissen är nu på våning:" + curFloor + " åker uppåt");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curFloor = curFloor + 1;
		System.out.println("Hissen är nu på våning:" + curFloor);
	}
	
	private void moveDownOneFloor()  {
		System.out.println("Hissen är nu på våning:" + curFloor + " åker nedåt");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curFloor = curFloor  - 1;
		System.out.println("Hissen är nu på våning:" + curFloor);
	}
	public void enterElevator(Person p) {
		//check for maxweigh
		if (! doorClosed) {
			persons.add(p);
		}	
	}
	public void printAllPersonsInElevator() {
		for (Person curP : persons) {
			System.out.println("--------------Alla i hissen----------------");
			System.out.println(curP.getName() + " Just nu på vån:" + curP.getCurrentFloor() + " Skall åka till vån:" + curP.getDesieredFloor());
		}
		System.out.println("---------------------------");
	}
	private void stopAtFloor() {
		for (Person curP : persons) {
			if (curP.getDesieredFloor() == this.getCurFloor()) {
				//Get persons out.
				curP.setCurrentFloor(this.getCurFloor());
				System.out.println(curP.getName() + " kliver av på vån " + this.getCurFloor());
				persons.remove(curP);
				
			}
		}
		
	}
	
	
}
