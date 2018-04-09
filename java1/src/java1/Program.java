package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Välj 1 för att räkna ord 2 för att räkna bokstäver 3 för att räkna båda välj esc för att återgå till huvudmeny");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(input.readLine());
		
		
		
		if (val == 1){
			System.out.println("val1");
			System.out.println("Antal ord:" + countWords(readInText()));
		}
		if (val ==2){
			System.out.println("val2");
			System.out.println("Antal bokstäver:" + countLetters(readInText()));
		}
		if (val == 3){
			System.out.println("val3");
			String textInput = readInText();
			System.out.println("Antal bokstäver:" + countLetters(textInput));
			System.out.println("Antal ord:" + countWords(textInput));
		}
		

	}
	
	public static int countWords(String string) {
		
		int noOfWords = 0;
		
		String[] ord = string.split("\\b");
		
		for (String theOrd : ord)
			if(theOrd.matches("\\w+")) 
				noOfWords++;	
		return noOfWords;
	}
	public static int countLetters(String string) {
		
		int noOfLetters = 0;
		
		
		for (int i = 0; i < string.length(); i++) {
			
			if (string.substring(i,i+1).matches("[a-z]") ) {
				noOfLetters++;
			}	
		}	
		return noOfLetters;
	}
	
	public static String readInText() throws IOException {
			
		System.out.println("Skriv in textmassa avsluta med enter:");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		return input.readLine();
	}
	
	

}
