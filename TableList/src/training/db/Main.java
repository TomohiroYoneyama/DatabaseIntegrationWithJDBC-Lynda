package training.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import util.InputHelper;
import db.tables.*;
import training.db.beans.*;


import util.InputHelper;

public class Main {
	
	
	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Starting application");
		
		ConnectionManager.getInstance().setDBType(DBtype.MYSQL);
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResultSet rsTable = null;
		ResultSet rsColumns = null;
		ArrayList<String> tables = new ArrayList<>();
		
		try{
			DatabaseMetaData metadata = conn.getMetaData();
			String[] tableType = {"TABLE"};
			rsTable = metadata.getTables(null, "%", "%", tableType);
			while(rsTable.next()){
				tables.add(rsTable.getString("TABLE_NAME"));
				
				for(String tableName : tables){
					
				     System.out.println(tableName);
				     System.out.println("-------------------");
				     
				      rsColumns = metadata.getColumns(null, "%", tableName, "%");
				     while(rsColumns.next()){
				    	 StringBuffer  buffer = new StringBuffer();
				    	 buffer.append(rsColumns.getString("COLUMN_NAME"));
				    	 buffer.append(": ");
				    	 buffer.append(rsColumns.getString("TYPE_NAME"));
				    	 System.out.println(buffer.toString());
				     }
				     
				     System.out.println("");
				}
		
			}
		}catch(Exception e){
			System.err.println(e);
		}finally{
			rsTable.close();
		}
		
		
		
		ConnectionManager.getInstance().close();

	}

}
