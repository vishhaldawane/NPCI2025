package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Account;

public interface AccountRepository 
	extends JpaRepository<Account, Integer> {
	
	//JPQL							getter             Pojo              getter
	@Query(value = "SELECT SUM(a.accountBalance) FROM Account a WHERE a.accountName like :hint", nativeQuery = false)
    Float getSumOfBalanceWhereNameStartingWith1(@Param("hint") String hint);
	
	//NATIVE				real column        actual tablename
	@Query(value = "SELECT SUM(a.acbal) FROM account_master a WHERE a.acname like :hint", nativeQuery = true)
    Float getSumOfBalanceWhereNameStartingWith2(@Param("hint") String hint);

}
