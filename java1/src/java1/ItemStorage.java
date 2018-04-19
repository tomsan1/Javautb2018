package java1;

public class ItemStorage extends Storage<Item> {

	public Item getItem(int artNr){
		
		Item iToreturn = myStorage.stream()
				.filter(item -> item.getArtNr() == (artNr))
				.findFirst()
				.orElse(null);
				removeItem(artNr);
		return iToreturn;
		
	}
	public void removeItem(int artNr) {
		myStorage.remove(myStorage.stream()
				.filter(item -> item.getArtNr() == (artNr))
				.findFirst()
				.orElse(null));
	}
	public void printAllStorage() {
		for (Item cItem : myStorage) {
			System.out.println("------------------");
			System.out.println(cItem.toString());
			System.out.println("------------------");
		}
	}
	public boolean isAvalible(int artnr) {
		for (Item cItem : myStorage) {
			if (cItem.getArtNr() == artnr)
				return true; 
		}
		return false;
	}
}
