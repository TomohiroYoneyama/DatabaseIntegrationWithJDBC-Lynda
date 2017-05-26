package training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private static final String H_CONN_STRING = 
			"jdbc:hsqldb:data/explorecalifornia";
	private static final String M_CONN_STRING = 
			"jdbc:mysql://localhost/explorecalifornia";
	//    
	
	private DBtype dbtype = DBtype.MYSQL;
	
	private Connection conn = null;
	
	private ConnectionManager(){
	}
	
	public static ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public void setDBType(DBtype dbtype){
		this.dbtype = dbtype;
	}
	
	private boolean openConnection(){
		try{
			switch(dbtype){
			case MYSQL:
				conn = DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
				return true;
			case HSQLDB:
				conn = DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
				return true;
			default:
				return false;
			}
		}catch(SQLException e){
			System.out.println(e);
			return false;
		}
	}
	
	public Connection getConnection(){
		if ( conn == null){
			if (openConnection()){
				System.out.println("Connection opened");
				return conn;
			}else{
				return null;
			}
		}
		return conn;
	}
	
	public void close(){
		System.out.println("Closing Connection");
		try{
			conn.close();
			conn = null;
		}catch(Exception e){
			
		}
	}

	
	
	
	
	

}
