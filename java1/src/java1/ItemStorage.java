package java1;

public class ItemStorage extends Storage<Item> {

	

	public Item getItem(int artN) {
		for (Item cItem : myStorage) {
			if (cItem.getArtNr() == artN) {
				return cItem;
			}
		}
		return null;
	}
	
	public void printAllItemsInStorage() {
		System.out.println("-----------------------------");
		for (Item cItem : myStorage) {
			System.out.println("Artikelnummer:" + cItem.getArtNr() + " Beskrivning:" + cItem.getDecription() + " Antal:" + cItem.getQty());
		}
		System.out.println("-----------------------------");
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
	
	public boolean artNoAvalible(int artnr) {
		for (Item cItem : myStorage) {
			if (cItem.getArtNr() == artnr) {
				return false;
			}
		}
		return true;
	}
	
	public void addItems(int artN, int noToAdd) {
		for (Item cItem : myStorage) {
			System.out.println("Item:" + cItem.getArtNr());
			if (cItem.getArtNr() == artN) {
				cItem.setQty(cItem.getQty() + noToAdd);	
				return;
			}	
		}
	}
	public void removeItems(int artN, int noToRemove) {
		for (Item cItem : myStorage) {
			System.out.println("Item:" + cItem.getArtNr());
			if (cItem.getArtNr() == artN) {
				cItem.setQty(cItem.getQty() - noToRemove);
				return;
			}	
		}
	}
}
