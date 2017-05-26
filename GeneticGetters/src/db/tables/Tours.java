package db.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {
	public static void displayData(ResultSet rs) throws SQLException{
		
			while(rs.next()){
				StringBuffer buffer = new StringBuffer();
				
				int tourId = rs.getObject("tourId", Integer.class);
				String tourName = rs.getObject("tourName", String.class);
				BigDecimal price = rs.getObject("price", BigDecimal.class);
				
				//this runs but throw exception with HSQL because mySQL use bigDecimal not double
				//use BigDecimal type instead.
				//double price = rs.getObject("price", Double.class);
				
//				int tourId = rs.getInt("tourId");
//				String tourName = rs.getString("tourName");
//				double price = rs.getDouble("price");
				
				buffer.append("Tour "+ rs.getInt("tourID")+ ": ");
				buffer.append(rs.getString("tourName"));
				
				
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
				buffer.append(" (" + formattedPrice + ")");
				
				System.out.println(buffer.toString());
			}
		
	}

}
