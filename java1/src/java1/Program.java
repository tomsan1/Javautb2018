package java1;

import java.io.IOException;

import org.json.JSONException;

public class Program {

	static UserInterface myUI = new UserInterface();
	
	public static void main(String[] args) throws IOException, JSONException {
	
		myUI.runMenu();
		
	}
}
