package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
	
	
	ItemStorage myItemStorage = new ItemStorage();
	ShoppingCart myShoppingCart = new ShoppingCart();
	
	
	public void printMenu() {  
		System.out.println("-------------Meny-----------");  
		System.out.println("1. Skapa Artikel");  
		System.out.println("2. Visa alla artiklar");  
		System.out.println("3. Lägg till artikel i lager");  
		System.out.println("4. Visa alla artiklar i lager");  
		System.out.println("5. Lägg in artikel i varukorg");
		System.out.println("6. Visa alla artiklar i varukorg");
		System.out.println("7. Ta bort artikel från varukorg");
		System.out.println("8. Checka ut varukorg");
		System.out.println("9. Sök artikel i lager");
		System.out.println("----------------------------");  	
	}  
	
	public void runMenu() throws NumberFormatException, IOException {  
		 		 		  
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		
		boolean runMenu = true;  
		while (runMenu) {  
		 		 			 
			printMenu();  
		 		 			  
			int menuChoice = 0;  
			try{  
				menuChoice = Integer.parseInt(input.readLine());  
			}  
			catch (NumberFormatException e){  
				continue;  
			}  
			switch (menuChoice) {  
				case 1: System.out.println("Skapa artikel"); 
						Item i1 = createItem();
						myItemStorage.addItem(i1);
						break;
			
				case 2: System.out.println("Visa alla artiklar");
						myItemStorage.printAll();
		 				break;	
		 		 				
		 		case 3: System.out.println("Fyll på lager"); 
		 				addItemsToStorage();
		 				break;  
		 		 				  
		 		case 4: System.out.println("Visa alla artiklar i lager");
		 				myItemStorage.printAllItemsInStorage();
		 				break;  
		 		 				  
		 		case 5: System.out.println("Lägg artikel från lager till varukorg");  
		 				addToCartFromStorage();
		 				
		 				break; 
		 		case 6: System.out.println("Visa alla artiklar i varukorg");
		 				myShoppingCart.printAllInCart();
		 				break;
		 		case 7: System.out.println("Ta bort artikel ur varukorg");
		 				removeFromCartToStorage();
		 				break;
		 		case 8: System.out.println("Kassa");
 						myShoppingCart.checkOut();
 						break;
		 		case 9: System.out.println("Sök artikel i lager");
 						findItem();
 						break;
		 		}  
		 }  
	}  

	public Item createItem() throws IOException {
		
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		
		int artNo = 0;
		int price = 0;
		String d = "";
		
		while (artNo == 0 || price == 0) {
			System.out.println("Ange artnr:");
			try{
				artNo = Integer.parseInt(ir.readLine());
			}
			catch (NumberFormatException e){
				System.out.println("Endast siffror i artnr");
				
			}
			if (! myItemStorage.artNoAvalible(artNo)) {
				artNo = 0;
				System.out.println("Artikelnummer finns redan");
				continue;
			}
			System.out.println("Ange pris:");
			try{
				price = Integer.parseInt(ir.readLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Endast siffror i pris");
				continue;
			}
			System.out.println("Ange beskrivning");
			d = ir.readLine();
		}	
		return new Item(artNo, price, d, 0);
	}

	public void addItemsToStorage() throws IOException {
		
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNr = 0;
		int noToAdd =0;
		try {
			artNr = Integer.parseInt(ir.readLine());	
		}
		catch (NumberFormatException e) {
			System.out.println("Endast siffror i artnr");
			return;
		}
		try {
			System.out.println("Antal att lägga till i lager");
			noToAdd = Integer.parseInt(ir.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Endast siffror i artnr");
			return;
		}
		if (myItemStorage.isAvalible(artNr)) {
			System.out.println("Lägger till Artnr:" + artNr + " Antal:" + noToAdd);
			myItemStorage.addItems(artNr, noToAdd);	
		}
		else {
			System.out.println("Artikel saknas");
			
		}
		
	}
	
	public void addToCartFromStorage() throws NumberFormatException, IOException {
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNr = 0;
		int noToAdd = 0;
		
		try {
			artNr = Integer.parseInt(ir.readLine());
			
		}
		catch (NumberFormatException e) {
			System.out.println("Endast siffror i artnr");
			return;
		}
		
		System.out.println("Ange antal:");
		try {
			
			 noToAdd = Integer.parseInt(ir.readLine());
				
		}
		catch (NumberFormatException e) {
			System.out.println("Endast siffror i artnr");
			return;
		}
		
		if (artNr != 0) {
			
			if (myItemStorage.isAvalible(artNr)) {
				// go ahead
				System.out.println("artNr i ifsats:" + artNr + "noToadd i ifsats" + noToAdd);
				if (myItemStorage.isInStock(artNr, noToAdd)) {
				
					if (myShoppingCart.allreadyInCart(artNr)) {
						myItemStorage.removeItems(artNr, noToAdd);
						myShoppingCart.addItemsToCart(artNr, noToAdd);
					}
					else {
						Item itemToAdd = new Item(myItemStorage.getItem(artNr).getArtNr(), myItemStorage.getItem(artNr).getPrice(), myItemStorage.getItem(artNr).getDecription(), noToAdd);
						myShoppingCart.addItem(itemToAdd);
						myItemStorage.removeItems(artNr, noToAdd);
					}
				}
				else {
					System.out.println("Lagersaldo för lågt");
				}
			}
			else {
				System.out.println("Artikelnumer saknas i lager");
			}	
		}		
	}
	
	public void removeFromCartToStorage() throws NumberFormatException, IOException {
		
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNr = 0;
		int noToRemove = 0;
		
		try {
			artNr = Integer.parseInt(ir.readLine());
		}
		catch (NumberFormatException e){
			System.out.println("Endast siffror i artnr");
			return;
		}
		
		System.out.println("Ange antal att ta bort:");
		try {
			noToRemove = Integer.parseInt(ir.readLine());
		}
		catch (NumberFormatException e){
			System.out.println("Endast siffror");
			return;
		}
		
		if (artNr != 0) {	
			if (myShoppingCart.isAvalible(artNr)) {
				// go ahead
				if (myShoppingCart.isInStock(artNr, noToRemove)) {
					myShoppingCart.removeItemsFromCart(artNr, noToRemove);
					myItemStorage.addItems(artNr, noToRemove);			
				}
				else {
					System.out.println("Antal finns ej i kundkorg");
				}
			}
			else {
				System.out.println("Artikelnumer saknas i kundkorg");
			}
		}
	}
	
	public void findItem() throws NumberFormatException, IOException {
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artN = 0; 
		try {
			artN =Integer.parseInt(ir.readLine());
			
		}
		catch (NumberFormatException e) {
			System.out.println("endast siffror i artnr");
			return;
		}
		if (myItemStorage.isAvalible(artN)){
			System.out.println("Finns i lager");
			System.out.println(myItemStorage.getItem(artN).toString() + myItemStorage.getItem(artN).getQty());
		}
		else {
			System.out.println("Finns ej i lager");
		}
	}
	
}
