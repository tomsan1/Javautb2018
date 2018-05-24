package java1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgramTest {

	AccountManager myAccountManager = new AccountManager();
	TestingInterface myTi1;
	TestingInterface myTi2;
	TestingInterface myTi3;
	TestingInterface myTi4;
	TestingInterface myTi5;
	TestingInterface myTi6;
	
	@Before
	public void setUp() {
		
		
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
		
		myTi1 = new TestingInterface(myAccountManager);
		myTi2 = new TestingInterface(myAccountManager);
		myTi3 = new TestingInterface(myAccountManager);
		myTi4 = new TestingInterface(myAccountManager);
		myTi5 = new TestingInterface(myAccountManager);
		myTi6 = new TestingInterface(myAccountManager);
		
		Thread myThread1 = new Thread(myTi1);
		Thread myThread2 = new Thread(myTi2);
		Thread myThread3 = new Thread(myTi3);
		Thread myThread4 = new Thread(myTi4);
		Thread myThread5 = new Thread(myTi5);
		Thread myThread6 = new Thread(myTi6);
		
		
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
		myThread5.start();
		myThread6.start();
	}
	
	@Test
	public void TestIfDepositIsThreadSafe() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = Integer.MIN_VALUE;
		synchronized(myAccountManager) {
			result = myAccountManager.checkTransactionsAgainstAmount();
		}
		if (result == Integer.MIN_VALUE) {
			fail("Transactions are not accurate");
		}
		else {
			System.out.println("No of transactions tested:" + result);
		
		}
			
	}

}
