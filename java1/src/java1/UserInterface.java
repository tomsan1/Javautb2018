package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
	
	
	ItemStorage myItemStorage = new ItemStorage();
	ShoppingCart myShoppingCart = new ShoppingCart();
	
	public void printMenu() {  
		System.out.println("-------------Meny-----------");  
		System.out.println("1. Lägg in artikel i lagret");  
		System.out.println("2. Visa alla artiklar i lagret");  
		System.out.println("3. Visa alla artiklar i kundkorg");  
		System.out.println("4. lägg till artikel i kundkorg från lager");  
		System.out.println("5. ta bort artikel från kundkorg och lägg till lager");  
		System.out.println("6. Sök efter artikel på lager");
		System.out.println("7. Checka ut kundkorg");
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
				case 1: System.out.println("val 1"); 
						Item i1 = createItem();
						myItemStorage.addItem(i1);
						break;
			
				case 2: System.out.println("val 2");
						myItemStorage.printAllStorage();
		 				break;	
		 		 				
		 		case 3: System.out.println("val 3"); 
		 				myShoppingCart.printAllInCart();
		 				break;  
		 		 				  
		 		case 4: System.out.println("val 4");
		 				addToCartFromStorage();
		 				break;  
		 		 				  
		 		case 5: System.out.println("val 5");  
		 				removeFromCartToStorage();
		 				break; 
		 		case 6: System.out.println("val 6");
		 				findItem();
		 				break;
		 		case 7: System.out.println("val 7");
		 				myShoppingCart.checkOut();
		 		}  
		 	}  
		}  

	public Item createItem() throws IOException {
		
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNo = Integer.parseInt(ir.readLine());
		System.out.println("Ange pris:");
		int price = Integer.parseInt(ir.readLine());
		System.out.println("Ange beskrivning");
		String d = ir.readLine(); 
		
		return new Item(artNo, price, d);
	}
	public void addToCartFromStorage() throws NumberFormatException, IOException {
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNr = Integer.parseInt(ir.readLine());
		myShoppingCart.addItem(myItemStorage.getItem(artNr));
	}
	
	public void removeFromCartToStorage() throws NumberFormatException, IOException {
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		int artNr = Integer.parseInt(ir.readLine());
		myShoppingCart.addItem(myItemStorage.getItem(artNr));
		myItemStorage.addItem(myShoppingCart.getItem(artNr));
	}
	
	public void findItem() throws NumberFormatException, IOException {
		BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Ange artnr:");
		if (myItemStorage.isAvalible(Integer.parseInt(ir.readLine()))){
			System.out.println("Finns i lager");
		}
		else {
			System.out.println("Finns ej i lager");
		}
		
	}
	
}
