package java1;

public class Person {
	private int weight;
	private int gender; //1=male 2=fmale 3=other
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
}
