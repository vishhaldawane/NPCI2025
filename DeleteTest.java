import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import myexceptions.AccountNumberDoesNotExistsException;

public class DeleteTest {
	public static void main(String[] args) {
		
		
		//1. load the driver
		//org.hsqldb.jdbc.JDBCDriver
		
		try {
			System.out.println("Loading driver....");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded.....");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb",
															"SA", "");
			
			System.out.println("Connected to the Database : "+conn);
			
			Statement sqlStatement = conn.createStatement();
			
			//SELECT * FROM ACCOUNT_TBL
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Enter EXISTING account number to delete : ");
			int accountNumber = scanner1.nextInt();
			
			
			ResultSet resultSet = sqlStatement.executeQuery("select * FROM ACCOUNT_TBL "
					+ "where account_num="+accountNumber); //query is on primary key
			
			if( ! resultSet.next()) { //if that record exists
				throw new AccountNumberDoesNotExistsException("This account number"
						+ " DOES NOT exists : "+accountNumber);
			}
			else {
				PreparedStatement deleteStatement = conn.prepareStatement(""
						+ "DELETE from ACCOUNT_TBL WHERE ACCOUNT_NUM="+accountNumber);
				int rowsDeleted = deleteStatement.executeUpdate();
				System.out.println("Rows deleted : "+rowsDeleted);
				deleteStatement.close();
			}
			resultSet.close();
			
			sqlStatement.close();
			conn.close();
			System.out.println("Connection closed...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
