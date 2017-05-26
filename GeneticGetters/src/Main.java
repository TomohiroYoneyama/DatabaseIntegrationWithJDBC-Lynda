import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import db.tables.Tours;
import util.InputHelper;

public class Main {
	
	private static final String SQL = "{call GetToursWithCountByPrice(?,?)}";
	    //? is placeholder

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn2 = DBUtility.getConnection(DBtype.HSQLDB);
				Statement stmt = conn2.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM tours");
	
							
				){
			
			 
			Tours.displayData(rs);
			
			
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}catch(Exception e){
			System.err.println(e);
		}
		
		

	}

}
