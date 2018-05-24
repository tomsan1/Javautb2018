package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import java1.Account.Transaction;

public class TestingInterface implements Runnable {

	AccountManager myAccountManager;
	

	public TestingInterface(AccountManager am) {
		myAccountManager = am;
	}
	
	private void lockAccount() {
		Random myRandGen = new Random();  
		int accountid;
		
		//viewAllAccounts();
		
		accountid = myRandGen.nextInt(6);  
		synchronized(myAccountManager) {
			myAccountManager.getAccount(accountid).setActive(false);
		}
		
	}
	private void UnlockAccount()  {
		Random myRandGen = new Random();
		int accountid;
		
		//viewAllAccounts();
		accountid = myRandGen.nextInt(6);  
		synchronized(myAccountManager) {
			myAccountManager.getAccount(accountid).setActive(true);
		}
		
	}
	

	private void transfer() {
		Random myRandGen = new Random();
		
		int accountIdFrom;
		int accountIdTo;
		int amount;
		//viewAllAccounts();
		
		accountIdFrom = myRandGen.nextInt(6);  
		  
		accountIdTo = myRandGen.nextInt(6);  
		amount = myRandGen.nextInt(100);  
		  
		
		try {
			synchronized(myAccountManager) {
				myAccountManager.transfer(myAccountManager.getAccount(accountIdFrom),myAccountManager.getAccount(accountIdTo), amount);
			}
		} catch (InvalidBalanceException | LockedAccountException e) {
			//System.out.println("Transfer not possible");
			
		}
		
	}

	private void withdrawl() {
		Random myRandGen = new Random();
		int accountid;
		int amount;
		//viewAllAccounts();
		accountid = myRandGen.nextInt(6);  
		amount = myRandGen.nextInt(100);  
		
		try {
			synchronized(myAccountManager) {
				myAccountManager.getAccount(accountid).withdraw(amount);
			}
		} 
		catch (NullPointerException | InvalidBalanceException | LockedAccountException e) {
			//System.out.println("withdrawl not possible");
			
		}
		
	}

	private void deposit()  {
		Random myRandGen = new Random(); 
		int accountid;
		int amount;
		//viewAllAccounts();
		accountid = myRandGen.nextInt(6);  
		amount = myRandGen.nextInt(100);  
		  
		try {
			synchronized(myAccountManager) {
				myAccountManager.getAccount(accountid).deposit(amount);
			}
		} catch (NullPointerException | LockedAccountException e) {
			//System.out.println("deposit not possible account locked or do not exist");
			
		}
	}

	private void viewTransactionHistoryForAccount() {
		
		Random myRandGen = new Random();
		
		int accountid;
		//viewAllAccounts();
		accountid = myRandGen.nextInt(6);
		try {
			synchronized(myAccountManager) {
				for (Transaction cTrans : myAccountManager.getAccount(accountid).getTransactions()) {
					//System.out.println("Type:" + cTrans.getType() + " Time" + cTrans.getTime() + " Amount:" + cTrans.getAmount() );
				}
			}
		}
		catch(NullPointerException e){
			//System.out.println("Account does not exist");
		}
		
	}

	private void vievBalanceForSpecificAccount()  {
		Random myRandGen = new Random();
		int accountid;
		
		//viewAllAccounts();
		accountid = myRandGen.nextInt(6);  
		
		try {
			//System.out.println("Balance" + myAccountManager.getAccount(accountid).getBalance());
		}
		catch (NullPointerException e) {
			//System.out.println("Account does not exist");
		}
		
	}

	private void viewTotalBalance() {
		int total = 0;
		synchronized(myAccountManager) {
			for (Account cAccount : myAccountManager.getAllAccounts()) {
		
			total = total + cAccount.getBalance();
			}
		}
		//System.out.println("Total balance:" + total);
	}

	private void viewAllAccounts() {
		

	}
	
	
	
	@Override
	public void run() {
		while (true) {
			
			Random myRandGen = new Random();
				 			 
					 			  
			int menuChoice = myRandGen.nextInt(10);  
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
			switch (menuChoice) {  
				case 1: //System.out.println("View all accounts"); 
						viewAllAccounts();
						break;
					
				case 2: //System.out.println("View total balance");
						viewTotalBalance();
						break;	
				 		 				
				case 3: //System.out.println("View balance for specific account"); 
						vievBalanceForSpecificAccount();
						break;  
			 		 				  
				case 4: //System.out.println("View transaction history for specific account");
						viewTransactionHistoryForAccount();
						break;  
				 		 				  
				case 5: //System.out.println("Deposit");  
						deposit();
						break; 
				case 6: //System.out.println("Withdraw");
						withdrawl();
						break;
				case 7: //System.out.println("Transfer");
				 		transfer();
				 		break;
				case 8: //System.out.println("8. Lock account");
		 				lockAccount();
		 				break;
				case 9: //System.out.println("8. Unlock account");
						UnlockAccount();
						break;	  
			}	
		}
	}
}
