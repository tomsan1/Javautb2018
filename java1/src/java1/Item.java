package java1;

public class Item {
	private int artNumber;
	private int price;
	private String decription;
	
	
	public Item(int artnr, int pr, String d) {
		this.artNumber = artnr;
		this.price = pr;
		this.decription = d;
	}
	
	public int getArtNr() {
		return artNumber;
	}
	public void setArtNr(int artnr) {
		artNumber = artnr;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int p) {
		price = p;
	}
	
	public String getDecription() {
		return decription;
	}
	public void setDecrition(String d) {
		decription = d;
	}
	
	@Override
	public String toString() {
		String stringToReturn ="";
		stringToReturn = "Artikelnummer:" + artNumber + "\n" +
		"Pris:" + price + "\n" +
		"Beskrivning:" + decription;
		return stringToReturn;
	}
}