package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public static void main(String[] args) throws IOException {
	
		String menuChoice;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		printMenu();
		menuChoice = input.readLine();
		
		
		System.out.println(menuChoice);

	}
	public static void printMenu() {
		System.out.println("-------------Meny-----------");
		System.out.println("1. Ny Bokning ");
		}
}
