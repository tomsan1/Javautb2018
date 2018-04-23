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
		System.out.println("D�rren b�rjar �ppnas");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.doorClosed = false;
		System.out.println("D�rren helt �ppen");
	}
	public void closeDoor()  {
		System.out.println("D�rren b�rjar st�ngas");
		//Delay here 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.doorClosed = true;
		System.out.println("D�rren helt st�ngd");
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
					System.out.println("�ker ner");
					moveDownOneFloor();
				}
				if (destFloor > curFloor) {
					System.out.println("�ker upp");
					moveUpOneFloor();
				}
			}
		}
		else {
			System.out.println("Inte m�jligt att flytta hissen n�r d�rr �r �ppen");
		}
		
	}
	
	private void moveUpOneFloor()  {
		System.out.println("Hissen �r nu p� v�ning:" + curFloor + " �ker upp�t");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curFloor = curFloor + 1;
		System.out.println("Hissen �r nu p� v�ning:" + curFloor);
	}
	
	private void moveDownOneFloor()  {
		System.out.println("Hissen �r nu p� v�ning:" + curFloor + " �ker ned�t");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curFloor = curFloor  - 1;
		System.out.println("Hissen �r nu p� v�ning:" + curFloor);
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
			System.out.println(curP.getName() + " Just nu p� v�n:" + curP.getCurrentFloor() + " Skall �ka till v�n:" + curP.getDesieredFloor());
		}
		System.out.println("---------------------------");
	}
	private void stopAtFloor() {
		for (Person curP : persons) {
			if (curP.getDesieredFloor() == this.getCurFloor()) {
				//Get persons out.
				curP.setCurrentFloor(this.getCurFloor());
				System.out.println(curP.getName() + " kliver av p� v�n " + this.getCurFloor());
				persons.remove(curP);
				
			}
		}
		
	}
	
	
}
