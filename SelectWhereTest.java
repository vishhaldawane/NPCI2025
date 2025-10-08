import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereTest {
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
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter account number to search : ");
			int accountNumber = scanner.nextInt();
			
			ResultSet resultSet = sqlStatement.executeQuery("select * FROM ACCOUNT_TBL "
					+ "where account_num="+accountNumber); //query is on primary key
			
			if(resultSet.next()) { //if that record exists
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println("---------------------------");
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

class AccountNumberDoesNotExistsException extends RuntimeException
{

	public AccountNumberDoesNotExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
