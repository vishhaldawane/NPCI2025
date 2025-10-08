package dao;

import java.util.List;

public class AccountDAOTest {
	public static void main(String[] args) {
		
	/*Account account = new Account();
		account.setAccountNumber(107);
		account.setAccountName("KISHAN KUMAR");
		account.setAccountBalance(77777);*/
		
		AccountDAO accDAO = new AccountDAOImpl();
		//accDAO.deleteAccount(107);
		
		/*Account acc = accDAO.selectAccount(101);
		System.out.println(acc.getAccountNumber());
		System.out.println(acc.getAccountName());
		System.out.println(acc.getAccountBalance());*/
		
		List<Account> accList = accDAO.selectAllAccounts();
		
		for(Account acc: accList) {
			System.out.println(acc.getAccountNumber());
			System.out.println(acc.getAccountName());
			System.out.println(acc.getAccountBalance());	
		}
	}
}	
