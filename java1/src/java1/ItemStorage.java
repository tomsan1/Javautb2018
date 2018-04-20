package java1;

public class ItemStorage extends Storage<Item> {

	
	public void removeItem(int artNr) {
		
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
			if (cItem.getArtNr() == artN) {
				System.out.println("lägger till WEWRW");
				cItem.setArtNr(5);
			}
		}
	}
}
