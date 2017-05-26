import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.tables.Tours;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		

		
//		//you can do this way but bad example. not clean
//		ResultSet rs = null;
//
//		try(
//				//autoclose
//				//mustbe java 7 or later to automatically these connection below 
//				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
//				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
//				
//				
//				
//				){
//			
//			stmt.setMaxRows(5); 
//			rs =  stmt.executeQuery("SELECT * FROM tours");
//			 
//			Tours.displayData(rs);
//			
//		}catch(SQLException e){
//			DBUtility.processException(e);
//		}finally{
//			rs.close();
//		}
		
		
		//this is much faster method. limit 5 and only retrive 5 from databse
		//expecially good for using a network database since retriving big data at once are not good
		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn2 = DBUtility.getConnection(DBtype.MYSQL);
				Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
				ResultSet rs2 =  stmt2.executeQuery(
						//limit (from row 0), (max 5 rows)
						"SELECT * FROM tours limit 0,5"
						);
				
				
				){
	
			Tours.displayData(rs2);
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}
		
		

	}

}
