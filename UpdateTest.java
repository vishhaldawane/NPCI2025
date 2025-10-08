import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import myexceptions.AccountNumberDoesNotExistsException;

public class UpdateTest {
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
			System.out.println("Enter EXISTING account number  : ");
			int accountNumber = scanner1.nextInt();
			
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter MODIFYING account holder name : ");
			String accountHolder = scanner2.next();
			
			Scanner scanner3 = new Scanner(System.in);
			System.out.println("Enter MODIFYING account balance     : ");
			int accountBalance = scanner3.nextInt();
			
			ResultSet resultSet = sqlStatement.executeQuery("select * FROM ACCOUNT_TBL "
					+ "where account_num="+accountNumber); //query is on primary key
			
			if(resultSet.next()) { //if that record exists
				
				PreparedStatement updateStatement = conn.prepareStatement(""
						+ "UPDATE ACCOUNT_TBL set ACCOUNT_NAME=?, ACCOUNT_BAL=? WHERE "
						+ "ACCOUNT_NUM=?");
				updateStatement.setString(1, accountHolder);
				updateStatement.setInt(2, accountBalance);
				updateStatement.setInt(3, accountNumber);

				int rowsUpdated = updateStatement.executeUpdate();
				System.out.println("Rows udpated : "+rowsUpdated);
				updateStatement.close();
			}
			else {
				throw new AccountNumberDoesNotExistsException("This account number does not exists : ");
 
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
