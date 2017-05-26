package training.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import util.InputHelper;
import db.tables.*;
import training.db.beans.*;


import util.InputHelper;

public class Main {
	
	
	
	private static final String SQL = "{call GetToursWithCountByPrice(?,?)}";
	    //? is placeholder

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Starting application");
		
		ConnectionManager.getInstance().setDBType(DBtype.MYSQL);
		Connection conn = ConnectionManager.getInstance().getConnection();
		//set auto commit to false.
		//not it has to manually commit to up date the database
		conn.setAutoCommit(false);
		
		
		AdminManager.dieplayAllRows();
		
		
		
		int adminId =InputHelper.getIntegerInput("select a row to update");
		Admin bean = AdminManager.getRow(adminId);
		if( bean== null){
			System.out.println("Row not found");
			return;
		}
		
		String password = InputHelper.getInput("enter new password: ");
		bean.setPassword(password);
		
		if(AdminManager.updateRS(bean)){
			System.out.println("Success");
		}else{
			System.out.println("whoops");
		}
		
	
		conn.commit();
		System.out.println("transaction is commited");
		//conn.rollback();
		
		
		
		ConnectionManager.getInstance().close();

	}

}
