package java1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Elevator implements Runnable {
	
	private int topFloor;
	private int bottomFloor;
	private int curFloor;
	private boolean doorClosed;
	private boolean goingUp;
	private List<Integer> buttonsPushed;
	
	
	public Elevator (int topF, int bottomF) {
		//Create new elevator and put it on bottomfloor and close door.
		this.topFloor = topF;
		this.bottomFloor = bottomF;
		this.curFloor = this.topFloor;
		doorClosed = true;
		goingUp = true;
		this.buttonsPushed = new ArrayList<>();
		
	}
	
	public int getNoOfFloors() {
		return topFloor - bottomFloor;
	}
	
	public void  openDoor()  {
		if (doorClosed) {
			System.out.print("Dörren öppnas.");
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(5);
					System.out.print(".");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.doorClosed = false;
			System.out.println("Dörren öppen");
		}
	}
	public void closeDoor()  {
		
		if (! doorClosed) {
			System.out.print("Dörren stängs.");
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(5);
					System.out.print(".");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.doorClosed = true;
			System.out.println("Dörren stängd");
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
		
		int bpListSize;
		synchronized(buttonsPushed) {
			bpListSize = buttonsPushed.size();
		}
		
		
		if (bpListSize > 0) {
			// get the highest and lowest floor pushed
			int high = curFloor;
			int low = curFloor;
			
			synchronized(buttonsPushed) {
				for (Integer cBp : buttonsPushed) {
					if (cBp.intValue() > high) {
						
							high = cBp.intValue();
							bpListSize = buttonsPushed.size();
						
								
					}
					if (cBp.intValue() < low) {
						
					
							low = cBp.intValue();
							bpListSize = buttonsPushed.size();
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
			System.out.print("Åker från våning:" + curFloor + " på väg upp.");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print(".");
					Thread.sleep(5);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curFloor = curFloor + 1;
			System.out.println(" framme vid våning " + curFloor);
			checkingFloor();
		}
		else {
			closeDoor();
		}	
	}
	
	
	private void moveDownOneFloor()  {
		
		if (doorClosed) {
			System.out.print("Åker från våning:" + curFloor + " på väg ner");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print(".");
					Thread.sleep(5);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curFloor = curFloor - 1;
			System.out.println(" framme vid våning " + curFloor);
			checkingFloor();
			
		}
		else {
			closeDoor();
		}
		
	}
	
	
	private void checkingFloor()  {
		// check if button is pushed for this floor
		// is the elevator supposed to stop at this floor?
		boolean haveStoppedOnThisFloor = false;
		synchronized(buttonsPushed) {
			for (Integer cBp : buttonsPushed) {
				if (cBp.intValue() == curFloor){
					haveStoppedOnThisFloor = true;
					System.out.println("Stannar på våning:" + curFloor);
					openDoor();
					try {
						System.out.print("Väntar.");
						for (int i = 0; i < 7 ; i++) {
							System.out.print(".");
							Thread.sleep(2);
						}
						System.out.println("");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					closeDoor();
					//remove current floor from buttonsPushed if elevator has stopped...
					if (haveStoppedOnThisFloor) {
						removePushedButtons(curFloor);
						return;
					}
				}
			}
			
			
		}
	}
	
	public void pushButton(Integer i) {
		synchronized(buttonsPushed) {
			buttonsPushed.add(i);
		}
	}
	public void removePushedButtons(int i) {
		synchronized(buttonsPushed) {
			
			buttonsPushed = buttonsPushed.stream().filter(b -> b.intValue() != i).collect(Collectors.toList());
		}
	}
	@Override
	public void run() {
		while(true) {
			moveElevator();
			try {
				Thread.sleep(100);
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
