package java1;

import java.util.ArrayList;


public class Elevator implements Runnable {
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
		this.curFloor = this.topFloor;
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
			
			synchronized(buttonsPushed) {
				for (Integer cBp : buttonsPushed) {
				
					if (cBp.intValue() > high) {
						high = cBp.intValue();
					
					}
					if (cBp.intValue() < low) {
						low = cBp.intValue();
					}
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
			closeDoor();
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
			checkingFloor();
			
		}
		else {
			closeDoor();
		}
		
	}
	/*public void enterElevator(Person p) {
		//this.openDoor();
		//persons.add(p);
		//System.out.println(p.getName() + " g�r in i hissen");
		//this.closeDoor();
	}*/
	
	private void checkingFloor()  {
		// check if button is pushed for this floor
		// is the elevator supposed to stop at this floor?
		
		for (Integer cBp : buttonsPushed) {
			if (cBp.intValue() == curFloor){
				
				//Stop elevator and remove this cBp
				synchronized(buttonsPushed) {
					buttonsPushed.remove(cBp);
				}
				
				System.out.print("Stannar p� v�ning:" + curFloor);
				try {
					for (int i = 0; i < 7 ; i++) {
						System.out.print(".");
						Thread.sleep(200);
					}
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		
	}
	
	public void pushButton(Integer i) {
		synchronized(buttonsPushed) {
			buttonsPushed.add(i);
		}
	}
	@Override
	public void run() {
		while(true) {
			for (Integer cbp : buttonsPushed) {
				System.out.println("V�ningar som hissen skall till: " + cbp.intValue());
			}
			moveElevator();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Never end mainThread/Always be able to make decisions
			//Move elevator if request exist
			//Notify people where the elevator is and what the state of the doors are
			//Gather decisions from people where they want to go
		}
	}
	
}
