package com.example.demo;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	Account account;
	
	@Test
	public void findAccountTest() {		
		Optional<Account> accountFound = accountRepository.findById(102);
		if(accountFound.isPresent()) {
			Account actualObj = accountFound.get();
			System.out.println("Account Number  : "+actualObj.getAccountNumber());
			System.out.println("Account Name    : "+actualObj.getAccountName());
			System.out.println("Account Balance : "+actualObj.getAccountBalance());
		}
	}
	
	@Test
	public void findAllAccountsTest() {
		
		Iterable<Account> iterableAccounts = accountRepository.findAll();
		iterableAccounts.forEach( a-> {
			System.out.println("Account Number  : "+a.getAccountNumber());
			System.out.println("Account Name    : "+a.getAccountName());
			System.out.println("Account Balance : "+a.getAccountBalance());
			System.out.println("---------------");
		});
	}
	
	@Test
	public void updateExistingAccountTest() {	
		Optional<Account> accountFound = accountRepository.findById(102);
		if(accountFound.isPresent()) {
			Account actualObj = accountFound.get();
			System.out.println("Old Account Number  : "+actualObj.getAccountNumber());
			System.out.println("Old Account Name    : "+actualObj.getAccountName());
			System.out.println("Old Account Balance : "+actualObj.getAccountBalance());
			actualObj.setAccountName("NEW NAME");
			actualObj.setAccountBalance(99999);
			accountRepository.save(actualObj);
		}
	}
	
	@Test
	public void deleteExistingAccountTest() {	
		Optional<Account> accountFound = accountRepository.findById(102);
		if(accountFound.isPresent()) {
			
			Account account = accountFound.get();
			accountRepository.delete(account);
		}
	}

	@Test
	public void insertAccountTest() {
		
		Assertions.assertTrue(accountRepository!=null);
		System.out.println("Account Repository is ready...");
		
		Assertions.assertTrue(account!=null);
		System.out.println("Account Object is ready...");
		
		Account account1 = new Account();
		account1.setAccountNumber(102);
		account1.setAccountName("Jane");
		account1.setAccountBalance(600000);

		Account account2 = new Account();		
		account2.setAccountNumber(103);
		account2.setAccountName("Julie");
		account2.setAccountBalance(700000);

		Account account3 = new Account();		
		account3.setAccountNumber(104);
		account3.setAccountName("Julia");
		account3.setAccountBalance(800000);

		Account account4 = new Account();		
		account4.setAccountNumber(105);
		account4.setAccountName("Smith");
		account4.setAccountBalance(900000);

		accountRepository.save(account1);
		accountRepository.save(account2);
		accountRepository.save(account3);
		accountRepository.save(account4);
		
		System.out.println("Account Object is persisted...");
	}
	
	
	@Test
	public void testSumByAccNameStartingWith() {

		//JPQL
		Float sum1 = accountRepository.getSumOfBalanceWhereNameStartingWith1("J%");
		System.out.println("Sum1 : "+sum1);
		
		Float sum2 = accountRepository.getSumOfBalanceWhereNameStartingWith2("S%");
		System.out.println("Sum2 : "+sum2);
		
		
	}
	
	
	
	@Autowired
	Car carObj;
	
	@Test
	void createCarObjectTest() {
		
		Assertions.assertTrue(carObj!=null);
		System.out.println("Yes Car is created....");
	}
	
	@Test
	void contextLoads() {
		
		Assertions.assertTrue(10>5);
		System.out.println("passed1");
		
		Assertions.assertTrue(5<12);
		System.out.println("passed2");

		Assertions.assertTrue(15>120);
		System.out.println("passed3");
		
		Assertions.assertTrue(150>120);
		System.out.println("passed4");
		
		Assertions.assertTrue(150<1220);
		
		System.out.println("passed5");
		
	}

}
