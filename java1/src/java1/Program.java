package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Välj 1 för att räkna ord 2 för att räkna bokstäver");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		if (Integer.parseInt(input.readLine()) == 1){
			System.out.println("val1");
			System.out.println(countWords(readInText()));
			
		}
		else {
			System.out.println("val2");
			System.out.println(countLetters(readInText()));
		}
		

	}
	
	public static int countWords(String string) {
		
		System.out.println(string);
		
		//pattern och matcher
		return 1;
	}
	public static int countLetters(String string) {
		//pattern och matcher
		System.out.println(string);
		return 1;
	}
	
	public static String readInText() throws IOException {
		
		
		char c = 'a';
		
		System.out.println("Skriv in textmassa avsluta med enter:");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//Testar
		//c = (char)input.read();
		
		//System.out.println(c);
		
		return input.readLine();
	}
	
	

}
