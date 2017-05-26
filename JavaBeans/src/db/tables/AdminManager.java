package db.tables;
import training.db.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminManager {
	
	public static void displayAllRows() throws SQLException {
		String sql = "SELECT admin Id, userName, password FROM admin";
		
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
	
			){
			
			System.out.println("Admin Table");
			
			while(rs.next()){
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("adminId") + ": ");
				bf.append(rs.getString("userName") + ": ");
				bf.append(rs.getString("password"));
				System.out.println(bf.toString());
				
			}
		}
		
	}

}
