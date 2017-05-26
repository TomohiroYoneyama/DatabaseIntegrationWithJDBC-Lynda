import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.tables.States;
import db.tables.Tours;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
					);			
				ResultSet rs =  stmt.executeQuery("SELECT * FROM states");
				
				
				){
	         
			States.displayData(rs);
			
			rs.last();
			//return row number of current cursor
			System.out.println("Number Of Rows: " + rs.getRow());
			
			rs.first();
			System.out.println("The first state is "+ rs.getString("stateName"));
			
			rs.last();
			System.out.println("The last state is "+ rs.getString("stateName"));
			
			rs.absolute(10);
			System.out.println("The 10th state is "+ rs.getString("stateName"));
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}
		
		

	}

}
