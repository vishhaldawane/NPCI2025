package com.example.demo;//1

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//comm/dcomm

//2
@Component
@Entity
@Table(name="account_master")
public class Account {

	//3
	public Account() {
		System.out.println("Account() ctor");
	}
	
	//4
	@Id
	@Column(name="acno")
	private int accountNumber; //same as per the column in account_tbl

	@Column(name="acname", length=20)
	private String accountName; //same as per the column in account_tbl

	@Column(name="acbal")
	private int accountBalance; //same as per the column in account_tbl
	
	//5 introspect the data 
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
}
