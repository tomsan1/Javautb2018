package java1;

import java.io.IOException;

public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		AccountManager myAccountManager = new AccountManager();
		Account a1 = new Account(0,"kalle");
		Account a2 = new Account(1,"kalle");
		Account a3 = new Account(2,"kalle");
		Account a4 = new Account(3,"kalle");
		Account a5 = new Account(4,"kalle");
		Account a6 = new Account(5,"kalle");
		
		myAccountManager.addAccount(a1);
		myAccountManager.addAccount(a2);
		myAccountManager.addAccount(a3);
		myAccountManager.addAccount(a4);
		myAccountManager.addAccount(a5);
		myAccountManager.addAccount(a6);
		
		UserInterface myUi = new UserInterface(myAccountManager);
		TestingInterface myTi = new TestingInterface(myAccountManager); 
		Thread myThread1 = new Thread(myTi);
		Thread myThread2 = new Thread(myUi);
		
		myThread2.start();
		myThread1.start();
		
		
	}
}
