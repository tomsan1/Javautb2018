import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserInterface {

	
	
	public void printMenu() { 
		 		System.out.println("-------------Meny-----------"); 
		 		System.out.println("1. Givet int-Array plocka ut samtliga dubletter(använder Array, färdigskriven"); 
		 		System.out.println("2. Givet int-array plocka ut samtliga dubletter (använder set"); 
		 		System.out.println("3. Given en int-array och ett värde lägga till värdet i slutet av den arrayen, ändra storlek om så måste (anv arraylist)"); 
		 		System.out.println("4. Givet en int-array och ett värde plocka bort den första förekomesen av värdet ur arrayen och krympa den"); 
		 		System.out.println("5.Givet en int-array och en string array skapa en Map men nycklar från intarray och värde från string array"); 
		 		System.out.println("9. Avsluta"); 
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
		 						int[] intArray = new int[] {1,2,4,3,4};
		 						ass1(intArray);
		 						break; 
		 			 
		 				case 2: System.out.println("val 2");
		 						int[] intArray2 = new int[] {1,2,4,3,4};
		 						ass2(intArray2);
		 						break;		 
		 				case 3: System.out.println("val 3");
		 						int[] intArray3 = new int[] {1,2,4,3,4};
		 						ass3(intArray3, 7);
		 						break; 
		 				 
		 				case 4: System.out.println("val 4");
		 						int[] intArray4 = new int[] {1,2,4,3,4};
		 						ass4(intArray4, 4);
		 						break; 
		 				 
		 				case 5: System.out.println("val 5"); 
		 						int[] intArray5 = new int[] {1,2,3};
		 						String[] stringArray = new String[]  {"Kalle", "Pelle", "Olle"};
		 						ass5(intArray5, stringArray);
		 						break; 
		 			} 
		 		} 
		 	} 

	public void ass1(int[] intArray) {
		for (int i = 0; i < intArray.length; i++ ) {
			for (int c = 0; c < intArray.length; c++) {
				if (intArray[i] == intArray[c] && c != i) {
					System.out.println("Det finns dublett av:" + intArray[i]);
				}
			}
			
		}
		

	}
	public void ass2(int[] intArray) {
		Set<Integer> mySet = new HashSet<Integer>();
		
		for (int i = 0; i < intArray.length; i++) {
			if (!mySet.add(intArray[i])) {
				System.out.println("Värde:" + intArray[i] + " sattes ej in det finns redan i listan.");
			}
			
		}
			
	}
	public void ass3(int[] intArray, int intToAdd) {
		
		ArrayList<Integer> myAList = new ArrayList<>();
	
		for (int i = 0; i < intArray.length; i++) {
			myAList.add(intArray[i]);
		}
		
		System.out.println("Så här ser listan ut före den är tillagd:");
		for (Integer curInt : myAList) {
			System.out.println(curInt);
		}
		
		myAList.add(intToAdd);
		
		System.out.println("Så här ser listan ut efter den är tillagd:");
		for (Integer curInt : myAList) {
			System.out.println(curInt);
		}
		
	}
	public void ass4(int[] intArray, int intToRemove) {
		
		ArrayList<Integer> myAList = new ArrayList<>();
		boolean foundFirst = false;
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == intToRemove && ! foundFirst) {
				System.out.println("Hittade första " + intToRemove + " i listan och tog bort den");
				foundFirst = true;
			}
			else {
				myAList.add(intArray[i]);
			}
		}
		
		System.out.println("Så här ser listan ut efter den är borttagen:");
		for (Integer curInt : myAList) {
			System.out.println(curInt);
		}
	}
	public void ass5(int[] intArray, String[] myString) {
		Map<Integer, String> myMap = new HashMap<>();
		
		for (int i = 0; i < intArray.length; i++) {
			myMap.put(intArray[i], myString[i]);
		}
		
		System.out.println(myMap.toString());
		
	}
	
}
