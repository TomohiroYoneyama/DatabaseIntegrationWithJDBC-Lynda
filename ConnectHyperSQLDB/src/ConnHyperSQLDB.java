import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnHyperSQLDB {
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private static final String CONN_STRING = 
			"jdbc:hsqldb:data/explorecalifornia";
	     //connectionString:hsqldb:directoryOfpropety and script file

	public static void main(String[] args) throws  SQLException {
		// TODO Auto-generated method stub
		//loading driver 
		//Class.forName("com.mysql.jbdc.Driver");
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("connected to database");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM states");
			rs.last();
			System.out.println("number of rows : " + rs.getRow());
			
		}catch(SQLException e){
			System.err.println(e);
		}finally{
			if(conn !=null){
				conn.close();
			}
			
			if (stmt != null){
				stmt.close();
			}
			if (rs != null){
				rs.close();
			}
		}
	}

}
