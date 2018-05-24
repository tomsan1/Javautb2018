package java1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import javax.security.auth.login.AccountException;

import org.junit.Before;

public class AccountTest {
	Account myAccount;
	@Before
	public void setUp() {
		System.out.println("Before");
		myAccount = new Account();	
	}
	@Test
	public void NewAccountBalanceShouldBeZero() {
		System.out.println("newaccount...");
		assertEquals("New accountbalance was not zero", 0, myAccount.getBalance());
	}
	
	@Test
	public void TestDesposit5ShouldReturn5() throws LockedAccountException {
		myAccount.deposit(5);
		assertEquals("The amount after deposit was incorrect", 5, myAccount.getBalance());		
	}
	
	@Test(expected=InvalidBalanceException.class)
	public void TestWithdrawl10WhenAccountBalanceIsZero() throws InvalidBalanceException, LockedAccountException {
		myAccount.withdraw(10);
	}
	@Test
	public void TestWithdrawl10WhenBalanceIS15ShouldReturn5() throws InvalidBalanceException, LockedAccountException {
		myAccount.deposit(15);
		myAccount.withdraw(10);
		assertEquals("The amount after withdrawl was incorrect", 5, myAccount.getBalance());
	}
	@Test
	public void TestDeposit10AndSeThatTransactionIsSavedShouldReturnDeposit() throws LockedAccountException {
		myAccount.deposit(10);
		assertEquals("The String in type does not match", "Deposit", myAccount.getLastTransaction().getType());
	}
	@Test
	public void TestDeposit10AndSeThatTransactionIsSavedShouldReturnLastDepositOf10() throws LockedAccountException {
		myAccount.deposit(10);
		assertEquals("The amount does not match",10 ,myAccount.getLastTransaction().getAmount());
	}
	@Test
	public void TestDeposit10AndSeThatTransactionIsSavedShouldReturnDateOfDeposit() throws LockedAccountException {
		myAccount.deposit(10);
		assertEquals("The day of year is not valid",LocalDateTime.now().getDayOfYear() ,myAccount.getLastTransaction().getTime().getDayOfYear());
	}
	
	
	@Test
	public void TestWithdrawl10AndSeThatTransactionIsSavedShouldReturnWithdrawl() throws InvalidBalanceException, LockedAccountException {
		myAccount.deposit(20);
		myAccount.withdraw(10);
		assertEquals("The String in type does not match", "Withdrawl", myAccount.getLastTransaction().getType());
	}
	@Test
	public void TestWithdrawl10AndSeThatTransactionIsSavedShouldReturnLastWithdrawlf10() throws InvalidBalanceException, LockedAccountException {
		myAccount.deposit(20);
		myAccount.withdraw(10);
		assertEquals("The amount does not match",10 ,myAccount.getLastTransaction().getAmount());
	}
	@Test
	public void TestWithdrawl10AndSeThatTransactionIsSavedShouldReturnDateOfDeposit() throws InvalidBalanceException, LockedAccountException {
		myAccount.deposit(20);
		myAccount.withdraw(10);
		assertEquals("The day of year is not valid",LocalDateTime.now().getDayOfYear() ,myAccount.getLastTransaction().getTime().getDayOfYear());
	}
	@Test(expected = LockedAccountException.class)
	public void TestWitdrawl10WhenAccountIsLocked() throws InvalidBalanceException, LockedAccountException {
		myAccount.deposit(2000);
		myAccount.setActive(false);
		myAccount.withdraw(10);
	}
	
	@Test(expected = LockedAccountException.class)
	public void TestDepositl10WhenAccountIsLocked() throws InvalidBalanceException, LockedAccountException {
		myAccount.setActive(false);
		myAccount.deposit(2000);
	}
	
}
