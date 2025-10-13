package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired	AccountRepository accountRepository;
	@Override	public int findOutTheTotalLiabilityOfTheAccounts() {
		List<Account> accList = accountRepository.findAll();
		int totalLiability=0;
		for(Account account:accList) totalLiability+=account.getAccountBalance();
		return totalLiability;
	//	int totalLiability=accountRepository.findOutTotalBalance();
	//	return totalLiability;
	}
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
	public List<Account> findOutAccountsNumberGreaterThan(int acno) {
		// TODO Auto-generated method stub
		return null;
	}

}
