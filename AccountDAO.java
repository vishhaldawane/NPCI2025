package dao;

import java.util.List;

public interface AccountDAO {//poji
	//5 methods
	
	//CRUD
	void          insertAccount(Account acc); //C
	Account       selectAccount(int acno);    //R
	List<Account> selectAllAccounts();        //RA
	void          updateAccount(Account acc); //U
	void          deleteAccount(int acno);    //D
	int			  findOutTotalBalance();
	

}
