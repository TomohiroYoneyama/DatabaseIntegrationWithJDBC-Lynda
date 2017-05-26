import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.tables.Tours;
import util.InputHelper;

public class Main {
	
	private static final String SQL = "{call GetToursByPrice(?)}";
	    //? is placeholder

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Double maxPrice;
		try{
			maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
		}catch(NumberFormatException e){
			System.err.println("Error: invalid number");
			return;
		}
		
		ResultSet rs2 = null;

		try(
				//autoclose
				//mustbe java 7 or later to automatically these connection below 
				Connection conn2 = DBUtility.getConnection(DBtype.MYSQL);
				CallableStatement stmt2 = conn2.prepareCall(
						///////////
						SQL,
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
							
				){
			stmt2.setDouble(1, maxPrice);
			 rs2 =  stmt2.executeQuery();
			Tours.displayData(rs2);
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}
		
		

	}

}
