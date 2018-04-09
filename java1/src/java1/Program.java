package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
	while(true){
			
		
			System.out.println("V�lj 1 f�r att r�kna ord 2 f�r att r�kna bokst�ver 3 f�r att r�kna b�da");
		
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int val = Integer.parseInt(input.readLine());
		
			if (val == 1){
				System.out.println("val1");
				System.out.println("Antal ord:" + countWords(readInText()));
			}
			if (val ==2){
				System.out.println("val2");
				System.out.println("Antal bokst�ver:" + countLetters(readInText()));
			}
			if (val == 3){
				System.out.println("val3");
				String textInput = readInText();
				System.out.println("Antal bokst�ver:" + countLetters(textInput));
				System.out.println("Antal ord:" + countWords(textInput));
			}
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
			
			if (string.substring(i,i+1).matches("[a-zA-Z]")) {
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
