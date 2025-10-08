package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDAOImpl implements AccountDAO {
	
	Connection conn;

	AccountDAOImpl() {
		try {
			System.out.println("Loading driver....");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded.....");
			
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb",
															"SA", "");
			System.out.println("Connected to the Database : "+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertAccount(Account acc) {
	
		try {
			PreparedStatement insertStatement = conn.prepareStatement(""
					+ "INSERT INTO ACCOUNT_TBL VALUES (?,?,?)");
			insertStatement.setInt(1, acc.getAccountNumber());
			insertStatement.setString(2, acc.getAccountName());
			insertStatement.setInt(3, acc.getAccountBalance());
			int rowsAdded = insertStatement.executeUpdate();
			System.out.println("Rows created : "+rowsAdded);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Account selectAccount(int acno) {
		
		Account account = null;
		
		try {
			Statement sqlStatement = conn.createStatement();
			
			//SELECT * FROM ACCOUNT_TBL
			ResultSet resultSet = sqlStatement.executeQuery("select * "
					+ "FROM Account_tbl where account_num="+acno);
			
			if(resultSet.next()) {
				account = new Account();
				account.setAccountNumber(resultSet.getInt(1));
				account.setAccountName(resultSet.getString(2));
				account.setAccountBalance(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {

		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Statement sqlStatement = conn.createStatement();
			
			//SELECT * FROM ACCOUNT_TBL
			ResultSet resultSet = sqlStatement.executeQuery("select * FROM Account_tbl");
			
			while(resultSet.next()) {
				Account account = new Account();
				account.setAccountNumber(resultSet.getInt(1));
				account.setAccountName(resultSet.getString(2));
				account.setAccountBalance(resultSet.getInt(3));
				accountList.add(account); //store the account in the list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

	@Override
	public void updateAccount(Account acc) {


		try {
			PreparedStatement updateStatement = conn.prepareStatement(""
					+ "UPDATE ACCOUNT_TBL set ACCOUNT_NAME=?, ACCOUNT_BAL=? WHERE "
					+ "ACCOUNT_NUM=?");
			updateStatement.setString(1, acc.getAccountName());
			updateStatement.setInt(2, acc.getAccountBalance());
			updateStatement.setInt(3, acc.getAccountNumber());

			int rowsUpdated = updateStatement.executeUpdate();
			System.out.println("Rows udpated : "+rowsUpdated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int acno) {

		
			try {
				PreparedStatement deleteStatement = conn.prepareStatement(""
						+ "DELETE from ACCOUNT_TBL WHERE ACCOUNT_NUM="+acno);
				int rowsDeleted = deleteStatement.executeUpdate();
				System.out.println("Rows deleted : "+rowsDeleted);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
