package java1;

public class ShoppingCart extends Storage<Item> {
	
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
		int totPrice = 0;
		String receipt = "";
		
		for (Item cItem : myStorage) {
			totPrice = totPrice + cItem.getPrice();
			receipt = receipt +  "Artikel:"+ cItem.getDecription() + " pris:" + cItem.getPrice() + "\n";
		}
		
		
		System.out.println(receipt);
		System.out.println("Att betala:" + totPrice);
	}
	

}
