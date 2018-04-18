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
		 		System.out.println("1. Givet int-Array plocka ut samtliga dubletter(anv�nder Array, f�rdigskriven"); 
		 		System.out.println("2. Givet int-array plocka ut samtliga dubletter (anv�nder set"); 
		 		System.out.println("3. Given en int-array och ett v�rde l�gga till v�rdet i slutet av den arrayen, �ndra storlek om s� m�ste (anv arraylist)"); 
		 		System.out.println("4. Givet en int-array och ett v�rde plocka bort den f�rsta f�rekomesen av v�rdet ur arrayen och krympa den"); 
		 		System.out.println("5.Givet en int-array och en string array skapa en Map men nycklar fr�n intarray och v�rde fr�n string array"); 
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
				System.out.println("V�rde:" + intArray[i] + " sattes ej in det finns redan i listan.");
			}
			
		}
			
	}
	public void ass3(int[] intArray, int intToAdd) {
		
		ArrayList<Integer> myAList = new ArrayList<>();
	
		for (int i = 0; i < intArray.length; i++) {
			myAList.add(intArray[i]);
		}
		
		System.out.println("S� h�r ser listan ut f�re den �r tillagd:");
		for (Integer curInt : myAList) {
			System.out.println(curInt);
		}
		
		myAList.add(intToAdd);
		
		System.out.println("S� h�r ser listan ut efter den �r tillagd:");
		for (Integer curInt : myAList) {
			System.out.println(curInt);
		}
		
	}
	public void ass4(int[] intArray, int intToRemove) {
		
		ArrayList<Integer> myAList = new ArrayList<>();
		boolean foundFirst = false;
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == intToRemove && ! foundFirst) {
				System.out.println("Hittade f�rsta " + intToRemove + " i listan och tog bort den");
				foundFirst = true;
			}
			else {
				myAList.add(intArray[i]);
			}
		}
		
		System.out.println("S� h�r ser listan ut efter den �r borttagen:");
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
