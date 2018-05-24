package java1;

import java.util.ArrayList;
import java.util.List;

import java1.Account.Transaction;

public class AccountManager {
	List<Account> accounts;
	
	public AccountManager() {
		accounts = new ArrayList<>();
	}
	public void addAccount(Account a) {
		accounts.add(a);
	}
	public List<Account> getAllAccounts(){
		return accounts;
	}
	public Account getAccount(int i) {
		for (Account cAccount : accounts) {
			if(cAccount.getId() == i) {
				return cAccount;
			}
		}
		return null;
	}
	public void transfer(Account accountToTransferFrom, Account accountToTransferTo, int amount) throws InvalidBalanceException, LockedAccountException {
		
		if (accountToTransferFrom.getBalance() > amount && accountToTransferTo.isActive()) {
			accountToTransferFrom.withdraw(amount);
			accountToTransferTo.deposit(amount);
		}
		else {
			throw new InvalidBalanceException("Not sufficient funds in account");
			
		}
	
	}
	public int  checkTransactionsAgainstAmount() {
		int noOfTransactions=0;
		for (Account cAccount : accounts) {
			int accountAmount = 0;
			for(Transaction cTransaction : cAccount.getTransactions()) {
				noOfTransactions++;
				if (cTransaction.getType().equals("Deposit")) {
					accountAmount = accountAmount + cTransaction.getAmount();
				}
				if (cTransaction.getType().equals("Withdrawl")) {
					accountAmount = accountAmount - cTransaction.getAmount();
				}	
			}
			if (accountAmount != cAccount.getBalance()) {
				return Integer.MIN_VALUE;
			}	
		}
		return noOfTransactions; 
	}
	
	

}
