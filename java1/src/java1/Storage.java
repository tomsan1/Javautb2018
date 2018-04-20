package java1;


import java.util.ArrayList;
import java.util.List;


public class Storage<T> {
	
	//List<> myList = new List[T]();
	List<T> myStorage = new ArrayList<>();
	
	public void addItem(T aItem) {
		myStorage.add(aItem);
	}
	
	public void printAll() {
		System.out.println("----------------");
		for (int i = 0; i < myStorage.size(); i++) {
		
			System.out.println(myStorage.get(i).toString());
			System.out.println("----------------");
		}
	}
}
