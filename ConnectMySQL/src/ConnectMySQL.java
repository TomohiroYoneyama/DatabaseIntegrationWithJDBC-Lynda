import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectMySQL {
	
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING = 
			"jdbc:mysql://localhost/explorecalifornia";
	//                     IP address or name of server/ name of database

	public static void main(String[] args) throws  SQLException {
		// TODO Auto-generated method stub
		//loading driver 
		//Class.forName("com.mysql.jbdc.Driver");
		
		
		Connection conn = null;
		try{
			
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("connected to database");
		}catch(SQLException e){
			System.err.println(e);
		}finally{
			if(conn !=null){
				conn.close();
			}
		}
	}

}
