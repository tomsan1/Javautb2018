package java1;

public class ShoppingCart extends Storage<Item> {
	
	public Item getItem(int artNr){
	
	}
	
	public void removeItem(int artNr) {
		
	}
	
	public void printAllInCart() {
		for (Item cItem : myStorage) {
			if (cItem != null) {
				System.out.println("-------------------");
				System.out.println(cItem.toString());
				System.out.println("-------------------");
			}
		}
	}
	
	public void checkOut() {
	}
}
