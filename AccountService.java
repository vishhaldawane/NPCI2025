package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;

@Service
public interface AccountService {
	List<Account> findOutTotalBalanceOfHolderNameStartingWith(String hint);
	List<Account> findOutTotalBalanceOfHolderNameEndingWith(String hint);
	List<Account> findOutListOfAccountsWithBalanceGreaterThan(int balance);
	int           findOutTheTotalLiabilityOfTheAccounts();
	List<Account> findOutAccountsNumberGreaterThan(int acno);
}
