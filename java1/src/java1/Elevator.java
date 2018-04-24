package java1;

import java.util.ArrayList;


public class Elevator {
	private int topFloor;
	private int bottomFloor;
	private int curFloor;
	private boolean doorClosed;
	private boolean goingUp;
	private ArrayList<Integer> buttonsPushed;
	private ArrayList<Person> persons;
	
	public Elevator (int topF, int bottomF) {
		//Create new elevator and put it on bottomfloor and close door.
		this.topFloor = topF;
		this.bottomFloor = bottomF;
		this.curFloor = this.bottomFloor;
		doorClosed = true;
		goingUp = true;
		this.buttonsPushed = new ArrayList<>();
		this.persons = new ArrayList<Person>();
	}
	
	public void  openDoor()  {
		if (doorClosed) {
			System.out.print("D�rren �ppnas.");
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(500);
					System.out.print(".");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.doorClosed = false;
			System.out.println("D�rren �ppen");
		}
		else {
			System.out.println("Du f�rs�ker �ppna en redan �ppen d�rr har du inget b�ttre f�r dig....");
		}
	}
	public void closeDoor()  {
		
		if (! doorClosed) {
			System.out.print("D�rren st�ngs.");
			//Delay here 
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(500);
					System.out.print(".");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.doorClosed = true;
			System.out.println("D�rren st�ngd");
		}
		else {
			System.out.println("Du f�rs�ker st�nga en redan st�ngd d�rr har du inget b�ttre f�r dig....");
		}
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
	
	public void moveElevator() {
		while (buttonsPushed.size() > 0) {
			
			// get the highest and lowest floor pushed
			int high = curFloor;
			int low = curFloor;
			
			for (Integer cBp : buttonsPushed) {
				if (cBp.intValue() > high) {
					high = cBp.intValue();
				}
				if (cBp.intValue() < low) {
					low = cBp.intValue();
				}
			}
			// what way to go? up or down?
			if(goingUp) {
				// have we reached the topfloor or is the highest requested floor reached?
				
				if (curFloor == topFloor || curFloor == high) {
					goingUp = false;
				}
				else {
					moveUpOneFloor();
				}
			}
			if(! goingUp) {
				//have we reached the bottomfloor or is the lowest requested floor reached?
				
				if (curFloor == bottomFloor || curFloor == low) {
					goingUp = true;
				}
				else {
					moveDownOneFloor();
				}
			}
		}
	}
	
	private void moveUpOneFloor()  {
		if (doorClosed) {
			System.out.print("�ker fr�n v�ning:" + curFloor + " p� v�g upp.");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print(".");
					Thread.sleep(500);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curFloor = curFloor + 1;
			System.out.println(" framme vid v�ning" + curFloor);
			passingFloor();
		}
		else {
			System.out.println("D�rrfan �r ju inte st�ngd den h�r hissen r�r sig inte ur fl�cken...");
		}	
	}
	
	
	
	private void moveDownOneFloor()  {
		if (doorClosed) {
			System.out.println("�ker fr�n v�ning:" + curFloor + " p� v�g ner");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curFloor = curFloor - 1;
			System.out.println("Kommer till v�ning" + curFloor + " p� v�g ner");
			passingFloor();
			
		}
		else {
			System.out.println("D�rrfan �r ju inte st�ngd den h�r hissen r�r sig inte ur fl�cken...");
		}
		
	}
	public void enterElevator(Person p) {
		//check for maxweigh
		if (! doorClosed) {
			System.out.println(p.getName() + " kliver p� hissen");
			persons.add(p);
		}
		else {
			System.out.println(p.getName() + " f�rs�ker kliva p� hissen n�r d�rren �r st�ngd.....");
		}
	}
	
	private void passingFloor() {
		// check if button is pushed for this floor
		// is the elevator supposed to stop at this floor?
		
		
		for (Person cP : persons) {
			if (cP.getDesieredFloor() == curFloor) {
				//stop elevator and remove this cp
				
				System.out.println("Stannar p� v�ning:" + curFloor);
				openDoor();
				System.out.println(cP.getName() + " kliver av p� v�ning:" + curFloor);
				
				closeDoor();
			}
		}
		for (Integer cBp : buttonsPushed) {
			if (cBp.intValue() == curFloor){
				//Stop elevator and remove this cBp
				System.out.println("Stannar p� v�ning:" + curFloor);
				buttonsPushed.remove(cBp);
				return;
			}
		}
		
	}
	
	public void pushButton(Integer i) {
		buttonsPushed.add(i);
	}
	
	public void run() {
		while(true) {
			//Never end mainThread/Always be able to make decisions
			//Move elevator if request exist
			//Notify people where the elevator is and what the state of the doors are
			//Gather decisions from people where they want to go
		}
	}
	
}
