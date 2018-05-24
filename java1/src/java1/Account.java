package java1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

	private int id;
	private String accountHolderName;
	private int balance;
	private boolean active;
	private List<Transaction> transactions;
	
	public class Transaction{
		
		private int amount;
		private String type;
		private LocalDateTime time;
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public LocalDateTime getTime() {
			return time;
		}
		public void setTime(LocalDateTime time) {
			this.time = time;
		}
	}
	
	public Account(int id, String name) {
		this.id = id;
		this.accountHolderName = name;
		this.balance = 0;
		transactions = new ArrayList<>();
		this.active = true;
	}
	
	public Account() {
		this.balance = 0;
		transactions = new ArrayList<>();
		this.active = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getBalance() {
		return balance;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	
	public void deposit(int i) throws LockedAccountException {
		if (this.isActive()) {
			this.balance = this.balance + i;
			Transaction myTrans = new Transaction();
			myTrans.setAmount(i);
			myTrans.setType("Deposit");
			myTrans.setTime(LocalDateTime.now());
			transactions.add(myTrans);
		}
		else {
			throw new LockedAccountException();
		}
	}

	public void withdraw(int i)throws InvalidBalanceException, LockedAccountException {
		if (this.balance < i) {
			throw new InvalidBalanceException();
		}
		else {
			if (this.isActive()) {
				this.balance = this.balance - i;
				Transaction myTrans = new Transaction();
				myTrans.setAmount(i);
				myTrans.setType("Withdrawl");
				myTrans.setTime(LocalDateTime.now());
				transactions.add(myTrans);
			}
			else {
				throw new LockedAccountException();
			}
			
		}
	}

	public Transaction getLastTransaction() {
		return transactions.get(transactions.size()-1);
	}
}
