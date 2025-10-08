package service;

import java.util.List;

import dao.Account;

public interface AccountService {

	List<Account> findOutTotalBalanceOfHolderNameStartingWith(String hint);
	List<Account> findOutTotalBalanceOfHolderNameEndingWith(String hint);
	List<Account> findOutListOfAccountsWithBalanceGreaterThan(int balance);
	int           findOutTheTotalLiabilityOfTheAccounts();
	List<Account> findOutAccountsNumberGreaterThan(int acno);
	
}
