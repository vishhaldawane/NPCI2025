package dao;//1

//comm/dcomm

//2
public class Account {

	//3
	public Account() {
		System.out.println("Account() ctor");
	}
	
	//4
	private int accountNumber; //same as per the column in account_tbl
	private String accountName; //same as per the column in account_tbl
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
