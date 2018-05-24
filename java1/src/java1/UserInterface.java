package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java1.Account.Transaction;

public class UserInterface implements Runnable{
	
	AccountManager myAccountManager;
	

public UserInterface(AccountManager am) {
		myAccountManager = am;
}
	
	public void printMenu() {  
		System.out.println("-------------Meny-----------");  
		System.out.println("1. View all accounts");  
		System.out.println("2. View total balance");  
		System.out.println("3. View balance for specific account");  
		System.out.println("4. View transaction history for specific account");  
		System.out.println("5. Deposit");
		System.out.println("6. Withdrawl");
		System.out.println("7. Transfer");
		System.out.println("8. Lock account");
		System.out.println("8. Unlock account");
		System.out.println("----------------------------");  	
	}  
	

	private void lockAccount() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		
		viewAllAccounts();
		System.out.println("Select account to lock by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		synchronized(myAccountManager) {
			myAccountManager.getAccount(accountid).setActive(false);
		}
		
	}
	private void UnlockAccount() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		
		viewAllAccounts();
		System.out.println("Select account to unlock by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		synchronized(myAccountManager) {
			myAccountManager.getAccount(accountid).setActive(true);
		}
		
	}
	

	private void transfer() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountIdFrom;
		int accountIdTo;
		int amount;
		viewAllAccounts();
		System.out.println("Select account by id to transfer from:");
		try{  
			accountIdFrom = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}
		System.out.println("Select account by id to transfer to:");
		try{  
			accountIdTo = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}
		
		System.out.println("Enter amount to transfer:");
		try{  
			amount = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}
		try {
			synchronized(myAccountManager) {
				myAccountManager.transfer(myAccountManager.getAccount(accountIdFrom),myAccountManager.getAccount(accountIdTo), amount);
			}
		} catch (InvalidBalanceException | LockedAccountException e) {
			System.out.println("Transfer not possible");
			
		}
		
	}

	private void withdrawl() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		int amount;
		viewAllAccounts();
		System.out.println("Select account by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		System.out.println("Enter amount to withdrawl:");
		try{  
			amount = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}
		try {
			synchronized(myAccountManager) {
				myAccountManager.getAccount(accountid).withdraw(amount);
			}
		} catch (NullPointerException | InvalidBalanceException | LockedAccountException e) {
			System.out.println("withdrawl not possible");
			
		}
		
	}

	private void deposit() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		int amount;
		viewAllAccounts();
		System.out.println("Select account by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		System.out.println("Enter amount to deposit:");
		try{  
			amount = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}
		try {
			synchronized(myAccountManager) {
				myAccountManager.getAccount(accountid).deposit(amount);
			}
		} catch (NullPointerException | LockedAccountException e) {
			System.out.println("deposit not possible account locked or do not exist");
			
		}
	}

	private void vievTransactionHistoryForAccount() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		
		viewAllAccounts();
		System.out.println("Select account by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		try {
			synchronized(myAccountManager) {
				for (Transaction cTrans : myAccountManager.getAccount(accountid).getTransactions()) {
					System.out.println("Type:" + cTrans.getType() + " Time" + cTrans.getTime() + " Amount:" + cTrans.getAmount() );
				}
			}
		}
		catch(NullPointerException e){
			System.out.println("Account does not exist");
		}
		
	}

	private void vievBalanceForSpecificAccount() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int accountid;
		
		viewAllAccounts();
		System.out.println("Select account by id:");
		try{  
			accountid = Integer.parseInt(input.readLine());  
		}  
		catch (NumberFormatException e){  
			return;
		}  
		try {
			
			synchronized(myAccountManager) {
				System.out.println("Balance" + myAccountManager.getAccount(accountid).getBalance());
			}
		}
		catch (NullPointerException e) {
			System.out.println("Account does not exist");
		}
		
	}

	private void viewTotalBalance() {
		int total = 0;
		synchronized(myAccountManager) {
			for (Account cAccount : myAccountManager.getAllAccounts()) {
				total = total + cAccount.getBalance();
			}
			System.out.println("Total balance:" + total);
		}
	}

	private void viewAllAccounts() {
		synchronized(myAccountManager) {
			for (Account cAccount : myAccountManager.getAllAccounts()) {
				System.out.println("-------------------------");
				System.out.println("AccountId    :" + cAccount.getId());
				System.out.println("AccountHolder:" + cAccount.getAccountHolderName());
				System.out.println("Balance:" + cAccount.getBalance());
				System.out.println("Active:" + cAccount.isActive());
			}
		}
		
	}  
	@Override
	public void run() {  
		 		 		  
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		
		
		while (true) {  
		 		 			 
			printMenu();  
		 		 			  
			int menuChoice = 0;  
			try{  
				try {
					menuChoice = Integer.parseInt(input.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}  
			catch (NumberFormatException e){  
				continue;  
			}  
			switch (menuChoice) {  
				case 1: System.out.println("View all accounts"); 
						viewAllAccounts();
						break;
			
				case 2: System.out.println("View total balance");
						viewTotalBalance();
		 				break;	
		 		 				
		 		case 3: System.out.println("View balance for specific account"); 
				try {
					vievBalanceForSpecificAccount();
				} catch (IOException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}
		 				break;  
		 		 				  
		 		case 4: System.out.println("View transaction history for specific account");
				try {
					vievTransactionHistoryForAccount();
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
		 				break;  
		 		 				  
		 		case 5: System.out.println("Deposit");  
				try {
					deposit();
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
		 				
		 				break; 
		 		case 6: System.out.println("Withdrawl");
				try {
					withdrawl();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		 				break;
		 		case 7: System.out.println("Transfer");
				try {
					transfer();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		 				break;
		 		case 8: System.out.println("8. Lock account");
				try {
					lockAccount();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 						break;
		 		case 9: System.out.println("8. Unlock account");
				try {
					UnlockAccount();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			}  
		}  
	}
}

	