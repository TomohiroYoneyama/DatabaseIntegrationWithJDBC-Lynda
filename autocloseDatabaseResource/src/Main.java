
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private static final String CONN_STRING = 
			"jdbc:hsqldb:data/explorecalifornia";
	     //connectionString:hsqldb:directoryOfpropety and script file

	public static void main(String[] args) throws  SQLException {
		// TODO Auto-generated method stub
		//loading driver 
		//Class.forName("com.mysql.jbdc.Driver");
		
		
		
		
		
		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
				ResultSet rs =  stmt.executeQuery("SELECT * FROM states");
				
				
				)
		{
			
		
			
			//
			//resultSetConcurrency indicate read only or updatable result set
		 stmt.executeQuery("SELECT * FROM states");
			
			rs.last();
			System.out.println("Number of rows: " + rs.getRow());
			
		
		}catch(SQLException e){
			System.err.println(e);
		}
	}

}
