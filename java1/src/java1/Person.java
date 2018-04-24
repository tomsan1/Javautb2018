package java1;

public class Person implements Runnable {
	private int weight;
	private int gender; //1=male 2=female 3=other
	private String name;
	private int currentFloor;
	private int desieredFloor;
	
	public Person(String n, int w, int g) {
		this.weight = w;
		this.gender = g;
		this.name = n;
		this.currentFloor = 0;
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
	public void enterElevator(Elevator e) {
		if (e.isDoorOpen()) {
			//check to ensure that person is on same floor as elevator
			if (e.getCurFloor() == this.getCurrentFloor()) {
				e.pushButton(desieredFloor);
				e.enterElevator(this);
			}
			else {
				System.out.println(this.getName() + " försöker gå in i hissen när han är på vån:" + this.getCurrentFloor() + " och hissen är på vån:" + e.getCurFloor() );
			}
		}
		else {
			System.out.println(this.getName() + " försöker gå in i hissen när dörren är stängd");
		}
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			//never end the thread/Make it possible for the person to always make new decisions
			//Decide where I want to go or decide if I should go in or out of the elevator
		}
		
	}
}
