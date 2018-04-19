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
		 		System.out.println("5. Givet en int-array och en string array skapa en Map men nycklar från intarray och värde från string array"); 
		 		System.out.println("6. Skapa en Array"); 
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
		 						
		 						int[] intArray1 = createArray();
		 						System.out.println("Array före ass1:");
		 						printArray(intArray1);
		 						ass1(intArray1);
		 						break; 
		 			 
		 				case 2: System.out.println("val 2");
		 						int[] intArray2 = createArray();
		 						System.out.println("Array före ass2:");
		 						printArray(intArray2);
		 						ass2(intArray2);
		 						
		 						break;		 
		 				case 3: System.out.println("val 3");
		 						int[] intArray3 = createArray();
		 						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 						System.out.println("Ange nummer att addera till listan");
		 						int intToAdd = Integer.parseInt(in.readLine());
		 						ass3(intArray3, intToAdd);
		 						
		 						break; 
		 				 
		 				case 4: System.out.println("val 4");
		 						int[] intArray4 = createArray();
		 						System.out.println("Array före ass4:");
		 						printArray(intArray4);
		 						BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
		 						System.out.println("Ange nummer att ta bort från listan");
		 						int intToRemove = Integer.parseInt(in2.readLine());
		 						ass4(intArray4, intToRemove);
		 						break; 
		 				 
		 				case 5: System.out.println("val 5"); 
		 						int[] intArray5 = new int[] {1,2,3};
		 						String[] stringArray = new String[]  {"Kalle", "Pelle", "Olle"};
		 						ass5(intArray5, stringArray);
		 						break; 
		 				case 6: System.out.println("Mata in värden i arrayen avsluta med enter mellan varje värde");
		 						int[] intArray8 = createArray();
		 						printArray(intArray8);
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
		System.out.println("Listan efter ass2:");
		for (Integer curInt : mySet) {
			System.out.println(curInt);
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
	public int[] createArray() throws IOException {
		ArrayList<Integer> myAList = new ArrayList<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Mata in intar i arrayen och tryck enter");
		String inInt = input.readLine();
		
		while (inInt.length() != 0) {
			myAList.add(Integer.parseInt(inInt));
			System.out.println("Lägger till:" + inInt + " i arrayen");
			inInt = input.readLine();
			
		}
		int[] intArray = new int[myAList.size()];
		
		for (int i = 0; i < myAList.size(); i++ ) {
			intArray[i] = myAList.get(i);
		}
		
		return intArray;
	}
	
	public void printArray(int[] intArray8) {
		
		for (int i = 0; i < intArray8.length; i++) {
			System.out.println("Position:" + i + " Värde:" + intArray8[i]);
		}
	}
	
}
