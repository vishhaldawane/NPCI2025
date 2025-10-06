import java.time.LocalDate;
//it is good to "FEEL GOOD" to have good habits
//it is bad  to  FEEL BAD  to remove bad habits


public class AccountTest {
	public static void main(String[] args) {
		Account accObjRef1 = new Account(101,"Jack",10000,LocalDate.of(2025, 12, 25));
	
		LocalDate date1 = LocalDate.of(2025, 3, 20);

	    accObjRef1.setAccount(7839,"Dhrubit",50000,date1);
	    accObjRef1.showAccount();
	    System.out.println("----------------");
	    
	    SavingsAccount savAcc = new SavingsAccount(102, "Raman", 200000, LocalDate.of(2024, 11, 23), 4.5f);
	    savAcc.showAccount();
	    savAcc.calculateSimpleInterest();
	    System.out.println("----------------");

	    FixedDepositAccount fd = new FixedDepositAccount(103, "Chaitraja", 300000, LocalDate.of(2024, 6, 20), 10.0f, LocalDate.of(2032, 6, 20));
	    fd.showAccount();
	    fd.calculateCompoundInterest();

	    
	    
	}
}
class Account {
	//DATA MEMBER SECTION
	private int accountNumber;	
	private String accountHolderName;	
	protected float accountBalance;
	protected LocalDate accountCreationDate;
	
	//MEMBER FUNCTIONS / METHODS
	void setAccount(int x, String y, float z, LocalDate ld) {
		System.out.println("setAccount(int,String,float) invoked......");
		accountNumber = x;
		accountHolderName= y;
		accountBalance = z;
		accountCreationDate = ld; 
	}
	
	Account(int x, String y, float z, LocalDate ld) {
		System.out.println("Account(int,String,float,LocalDate) invoked......");
		accountNumber = x;
		accountHolderName= y;
		accountBalance = z;
		accountCreationDate = ld; 
	}
	void showAccount() {
		System.out.println("ACCOUNT NUMBER   : "+accountNumber);
		System.out.println("ACCOUNT NAME     : "+accountHolderName);
		System.out.println("ACCOUNT BALANCE  : "+accountBalance);
		System.out.println("ACCOUNT OPN DATE : "+accountCreationDate);
		
		System.out.println("---------------------------------");
	}
	public void withdraw(float amountToWithdraw) {
		System.out.println("Withdrawing..amount : "+amountToWithdraw);
		if(amountToWithdraw > (accountBalance-5000)) {
			System.out.println("Insufficient funds.....");
		}
		else {
			accountBalance = accountBalance - amountToWithdraw;
		}
	}
	
	public void deposit(float amountToDeposit) {
		System.out.println("Depositing..amount : "+amountToDeposit);
		if(amountToDeposit > 50000) {
			System.out.println("SHOW YOUR PAN or PROOF OF "+amountToDeposit);
		}
		else {
			accountBalance = accountBalance + amountToDeposit;
		}
	}
	//Account() { }
}

class SavingsAccount extends Account
{
	protected float rateOfInterest;

	public SavingsAccount(int x, String y, float z, LocalDate ld, float rateOfInterest) {
		super(x, y, z, ld); //INVOKE NEAREST SUPER CLASS CTOR
		this.rateOfInterest = rateOfInterest;
		System.out.println("SavingsAccount(int,String,float,LocalDate,float) invoked......");

	}//Constructor call must be the first statement in a constructor

	void showAccount() {
		super.showAccount(); //INVOKE NEAREST SUPER CLASS FUNCTION		
		System.out.println("ACCOUNT ROI      : "+rateOfInterest);
		System.out.println("---------------------------------");
	}
	void calculateSimpleInterest() {
		float si = (accountBalance * 1 * rateOfInterest)/100;
		System.out.println("Simple Interest  : "+si);
	}
}

final class FixedDepositAccount extends SavingsAccount
{
	LocalDate dateOfMaturity;

	public FixedDepositAccount(int x, String y, float z, LocalDate ld, float rateOfInterest, LocalDate dateOfMaturity) {
		super(x, y, z, ld, rateOfInterest); //INVOKE NEAREST SUPER CLASS CTOR
		this.dateOfMaturity = dateOfMaturity;
		System.out.println("FixedDepositAccount(int,String,float,LocalDate,float,LocalDate) invoked......");

	}//Constructor call must be the first statement in a constructor

	void showAccount() {
		super.showAccount(); //INVOKE NEAREST SUPER CLASS FUNCTION		
		System.out.println("ACCOUNT Maturity : "+dateOfMaturity);
		System.out.println("---------------------------------");
	}
	//ci = P(1+r/100)^n - P
	
	// (  (1+R/100)^Year * p ) - p
	void calculateCompoundInterest() {
		int yearsDiff = dateOfMaturity.getYear() - accountCreationDate.getYear();
		
		double compoundInterest = accountBalance * (  Math.pow((1+rateOfInterest/100), yearsDiff)   ) - accountBalance;
		System.out.println("Compound Interest : "+ compoundInterest);
		System.out.println("Maturity Valuye   : "+ (accountBalance + compoundInterest));	

	}
}
/*
class CurrentAccount extends Account
{
	
}

class CreditAccount extends Account
{
	
}
*/

/*
class Person
{
	Person(int i) { }
}
class Student extends Person { 
	Student(int x) { }
	//B(){}
}

class Employee extends Student {
	Employee(int x) { }
}
class Executive extends Employee { }
*/




