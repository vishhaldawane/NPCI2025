public class SyncTest {
	public static void main(String args[]) throws InterruptedException {

		Account a1 = new Account(1,"Suresh",1000f);

		Transaction t1 = new Transaction("SEETA ",a1,200);
		Transaction t2 = new Transaction("\tREETA ",a1,300);
		Transaction t3 = new Transaction("\t\tGEETA ",a1,500);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("FINAL BAL :"+a1.getBalance());;
	}
}

class Transaction extends Thread {

   Account accObj; //hasA
   float amount;
   String tn;

	public Transaction(String tn, Account a, float amt) {
		accObj=a;
		amount = amt;
		this.tn = tn;
	}

	public void run() {
		accObj.deposit(amount,tn);
	}
}

class Account {

  private int accNumber;
  private String accName;
  private float bal;

	public Account(int acno, String name, float b) 	{
		accNumber = acno;
		accName = name;
		bal=b;
	}

	public float getBalance() {
	     try {
	    	 Thread.sleep(1500); //MIGHT BE A SELECT QUERY FROM A DB
	     }
           catch(InterruptedException e) {
	     }
	     return bal;
	}

	private void setBalance(float b) {
	     try {
	    	 Thread.sleep(1500);
	    	 bal=b; //AS IF A UPDATE QUERY OF THE DB
	     } 
	     catch(InterruptedException e) {
	     }
	}

	public    void deposit(float amt, String tn)  {

		//String threadName = Thread.currentThread().getName();
		
		System.out.println(tn+"1----------------------------------------");
		System.out.println(tn+"2----------------------------------------");
		System.out.println(tn+"3----------------------------------------");
		System.out.println(tn+"4----------------------------------------");
		synchronized(this) {
			float temp;
			System.out.println(tn+"Getting the balance ...");
			temp = getBalance();
			System.out.println(tn+"Balance got : " + temp);
			
			temp = temp + amt;
			
			System.out.println(tn+"Setting the balance ...");
			setBalance(temp);
			System.out.println(tn+"Balance set : " + temp);
		}
		
		//System.out.println("Depositing amount by "+threadName);		
		System.out.println(tn+"13----------------------------------------");
		System.out.println(tn+"14----------------------------------------");
		System.out.println(tn+"15----------------------------------------");
		System.out.println(tn+"16----------------------------------------");
	}
}