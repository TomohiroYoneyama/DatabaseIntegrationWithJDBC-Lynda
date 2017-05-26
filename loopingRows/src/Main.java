import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.tables.Tours;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
				ResultSet rs =  stmt.executeQuery("SELECT * FROM tours");
				
				
				){
	
			Tours.displayData(rs);
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}
		
		

	}

}
