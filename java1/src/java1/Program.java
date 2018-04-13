package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String operator = "";
		
		while (true) {
			
			System.out.println("Ange operand (+,-,*,/):");	
			try {
				operator = in.readLine();
				if (! operator.equals("+") && ! operator.equals("-") && ! operator.equals("*") && ! operator.equals("/")){
					throw new NumberFormatException();
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Endast (+,-,*,/) tillåtna");
				continue;
			}
		
			if (operator.equals("+") || operator.equals("-")){
			
				ArrayList<Double> allNumbers = new ArrayList<Double>();
				

				double result = 0;
				String nr = "0";
				while (! nr.equals("")){
					System.out.println("Ange tal att beräkna när du inte har fler tal tryck enter:");
					nr = in.readLine();
						double nrToWorkwith = 0;
						try{
							nrToWorkwith = Double.parseDouble(nr);
						}
						catch (NumberFormatException e) {
							System.out.println("Endast siffror är tillåtna");
							continue;
						}
						allNumbers.add(nrToWorkwith);

				}
				if (operator.equals("+")) {
					result = 0;
					for (Double aDoub : allNumbers) {
						
						result = result + aDoub.doubleValue(); 
					}
					System.out.println("Resultat:" + result);
				}
					
				if (operator.equals("-")) {
					result = allNumbers.get(0) + allNumbers.get(0);
					for (Double aDou : allNumbers) {
						
						result = result - aDou.doubleValue();
					}
					System.out.println("Resultat:" + result);
				}
			
			}
			
			
			if (operator.equals("*") || operator.equals("/")){

				double n1 = 0;
				double n2 = 0;
				
				System.out.println("Ange tal1:");
				
				try {
					
					n1 = Double.parseDouble(in.readLine());
				}
				catch (NumberFormatException e) {
					System.out.println("Endast siffror tillåtna");
					continue;
				
				}

				System.out.println("Ange tal2:");
				try {
					n2 = Double.parseDouble(in.readLine());
				}
				catch (NumberFormatException e) {
					System.out.println("Endast siffror tillåtna");
					continue;
					
				}
				try {
					System.out.println("Resultat:" + Double.toString(calculate(n1, n2, operator)));
				}
				catch (ArithmeticException e) {
					System.out.println("Kan ej dividera med 0");
					continue;
				}
			}
		}
	}
	
		public static double calculate(double n1, double n2, String operator) {
		
			double result = 0;
		
			if (operator.equals("*")) {
				result = n1 * n2;
				return result;
			}
			if (operator.equals("/")) {
				result = n1 / n2;
				return result;
			}
		
		
			return result;
		
		
		}
	
}
