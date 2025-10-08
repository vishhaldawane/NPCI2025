package service;

public class AccountServiceTest {
	public static void main(String[] args) {
		
		AccountService accountService = new AccountServiceImpl();
		
		int total = accountService.findOutTheTotalLiabilityOfTheAccounts();
		System.out.println("Total : "+total);
	}
}
