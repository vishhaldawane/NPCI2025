import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
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
			System.out.println("Enter new account number  : ");
			int accountNumber = scanner1.nextInt();
			
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter account holder name : ");
			String accountHolder = scanner2.next();
			
			Scanner scanner3 = new Scanner(System.in);
			System.out.println("Enter account balance     : ");
			int accountBalance = scanner3.nextInt();
			
			ResultSet resultSet = sqlStatement.executeQuery("select * FROM ACCOUNT_TBL "
					+ "where account_num="+accountNumber); //query is on primary key
			
			if(resultSet.next()) { //if that record exists
				throw new AccountNumberAlreadyExistsException("This account number"
						+ " already exists : "+accountNumber);
			}
			else {
				PreparedStatement insertStatement = conn.prepareStatement(""
						+ "INSERT INTO ACCOUNT_TBL VALUES (?,?,?)");
				insertStatement.setInt(1, accountNumber);
				insertStatement.setString(2, accountHolder);
				insertStatement.setInt(3, accountBalance);
				int rowsAdded = insertStatement.executeUpdate();
				System.out.println("Rows created : "+rowsAdded);
				insertStatement.close();
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

class AccountNumberAlreadyExistsException extends RuntimeException
{

	public AccountNumberAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
