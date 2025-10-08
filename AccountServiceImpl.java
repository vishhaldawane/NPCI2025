package service;

import java.util.List;

import dao.Account;
import dao.AccountDAO;
import dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {

	AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public List<Account> findOutTotalBalanceOfHolderNameStartingWith(String hint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findOutTotalBalanceOfHolderNameEndingWith(String hint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findOutListOfAccountsWithBalanceGreaterThan(int balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findOutTheTotalLiabilityOfTheAccounts() {
		/*List<Account> accList = accountDAO.selectAllAccounts();
		int totalLiability=0;
		for (Account account : accList) {
			totalLiability+=account.getAccountBalance();
		}
		return totalLiability;*/
		
		int totalLiability=accountDAO.findOutTotalBalance();
		return totalLiability;
	}

	@Override
	public List<Account> findOutAccountsNumberGreaterThan(int acno) {
		// TODO Auto-generated method stub
		return null;
	}

}
