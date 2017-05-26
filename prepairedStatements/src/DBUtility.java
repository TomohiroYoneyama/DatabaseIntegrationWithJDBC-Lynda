import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private static final String H_CONN_STRING = 
			"jdbc:hsqldb:data/explorecalifornia";
	private static final String M_CONN_STRING = 
			"jdbc:mysql://localhost/explorecalifornia";
	//                     IP address or name of server/ name of database
	
	public static Connection getConnection(DBtype dbType) throws SQLException{
		switch(dbType){
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		default:
			return null;
		}
		
	}
	
	public static void processException(SQLException e){
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code   : " + e.getErrorCode());
		System.err.println("Error state  : " + e.getSQLState());
	}

}

