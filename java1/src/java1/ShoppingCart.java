package java1;

import java.util.ArrayList;

public class ShoppingCart extends Storage<Item> {
	
	public Item getItem(int artNr){
		for (int i = 0; i < myStorage.size(); i++) {
			if (myStorage.get(i).getArtNr() == artNr) {
				return myStorage.get(i);
			}
				
		}
		return null;
	
	}
	
	public boolean allreadyInCart(int artN) {
		for (Item curI : myStorage) {
			if (curI.getArtNr() == artN) {
				return true;
			}
		}
		return false;
	}
	
	public void addItemsToCart(int artN, int noToAdd) {
		for (Item curI : myStorage) {
			if (curI.getArtNr() == artN) {
				curI.setQty(curI.getQty() + noToAdd);
			}
		} 
	}
	
	public void removeItemsFromCart(int artNr, int noToRemove) {
		for (Item curI : myStorage) {
			if (curI.getArtNr() == artNr) {
				curI.setQty(curI.getQty() - noToRemove);
			}
		}
		
	}
	
	public void printAllInCart() {
		for (Item cItem : myStorage) {
			if (cItem != null) {
				System.out.println("-------------------");
				System.out.println(cItem.toString() +  " Antal:" + cItem.getQty());
				System.out.println("-------------------");
			}
		}
	}
	
	public void checkOut() {
		
		int total = 0;
		String receipt = ""; 
		
		for (Item cItem : myStorage) {
				total = total + (cItem.getPrice() * cItem.getQty());
				receipt = receipt + cItem.getDecription() + " antal:" + cItem.getQty() + " pris:" + cItem.getPrice() + "\n";
		}
		
		System.out.println("---------Kvitto-----------");
		System.out.println(receipt);
		System.out.println("Totalt:" + total );
		System.out.println("--------------------------");
		myStorage = new ArrayList<>();
	}
	
	public boolean isAvalible(int artnr) {
		for (Item cItem : myStorage) {
			if (cItem.getArtNr() == artnr)
				return true; 
		}
		return false;
	}
	
	public boolean isInStock(int artnr, int n) {
		for (Item cItem : myStorage) {
			if (cItem.getArtNr() == artnr) {
				if (cItem.getQty() >= n)
				return true;
			}
			
		}
		return false;
	}
	
	
	
}
