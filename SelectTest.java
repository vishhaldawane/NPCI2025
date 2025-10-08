import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
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
			
			ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM ACCOUNT_TBL");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println("---------------------------");
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


