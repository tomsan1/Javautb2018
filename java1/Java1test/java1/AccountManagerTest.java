package java1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountManagerTest {
	
	AccountManager myAccountManager;
		
	@Before
	public void setUp() {
		myAccountManager = new AccountManager();
	}
	
	@Test(expected = NullPointerException.class)
	public void TestGetAccountFromEmptyAccountManagerShouldThrowException() {
		Account test = myAccountManager.getAccount(10);
		System.out.println(test.getAccountHolderName());
	}
	
	@Test
	public void TestRetriveAccountShouldReturnAccountId0() {
		Account ac = new Account();
		ac.setId(0);
		ac.setAccountHolderName("acholder");
		myAccountManager.addAccount(ac);	
		assertEquals("Account id does not match", 0, myAccountManager.getAccount(0).getId());
	}
	
	@Test
	public void TestTransferBetween2AccountsShouldReturn50() throws InvalidBalanceException, LockedAccountException {
		Account ac1 = new Account();
		ac1.setId(1);
		ac1.setAccountHolderName("acholder1");
		ac1.deposit(100);
		myAccountManager.addAccount(ac1);
		
		Account ac2 = new Account();
		ac2.setId(2);
		ac2.setAccountHolderName("acholder2");
		ac2.deposit(100);
		myAccountManager.addAccount(ac2);
		myAccountManager.transfer(ac1, ac2, 50);
		assertEquals("Accountbalance does not match", 50, myAccountManager.getAccount(1).getBalance());
	}
	
	@Test
	public void TestTransferBetween2AccountsShouldReturn150() throws InvalidBalanceException, LockedAccountException {
		Account ac1 = new Account();
		ac1.setId(1);
		ac1.setAccountHolderName("acholder1");
		ac1.deposit(100);
		myAccountManager.addAccount(ac1);
		
		Account ac2 = new Account();
		ac2.setId(2);
		ac2.setAccountHolderName("acholder2");
		ac2.deposit(100);
		myAccountManager.addAccount(ac2);
		myAccountManager.transfer(ac1, ac2, 50);
		assertEquals("Accountbalance does not match", 150, myAccountManager.getAccount(2).getBalance());
	}
	
	@Test(expected = InvalidBalanceException.class)
	public void TestTransferBetween2AccountsWhenNotSufficientFunds() throws InvalidBalanceException, LockedAccountException {
		Account ac1 = new Account();
		ac1.setId(1);
		ac1.setAccountHolderName("acholder1");
		ac1.deposit(10);
		myAccountManager.addAccount(ac1);
		
		Account ac2 = new Account();
		ac2.setId(2);
		ac2.setAccountHolderName("acholder2");
		ac2.deposit(100);
		myAccountManager.addAccount(ac2);
		myAccountManager.transfer(ac1, ac2, 50);
		assertEquals("Accountbalance does not match", 50, myAccountManager.getAccount(1).getBalance());
	}
	
	@Test(expected = LockedAccountException.class)
	public void TestTransferBetween2AccountsWhenAccountLocked() throws InvalidBalanceException, LockedAccountException {
		Account ac1 = new Account();
		ac1.setId(1);
		ac1.setAccountHolderName("acholder1");
		
		ac1.deposit(1000);
		ac1.setActive(false);
		myAccountManager.addAccount(ac1);
		
		Account ac2 = new Account();
		ac2.setId(2);
		ac2.setAccountHolderName("acholder2");
		ac2.deposit(1000);
		myAccountManager.addAccount(ac2);
		myAccountManager.transfer(ac1, ac2, 50);
		
	}
	
}
