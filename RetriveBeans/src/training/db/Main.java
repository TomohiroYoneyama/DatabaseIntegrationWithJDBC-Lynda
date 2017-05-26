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

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		AdminManager.dieplayAllRows();
		
		int adminId = InputHelper.getIntegerInput("Select a row: ");
		Admin bean = AdminManager.getRow(adminId);
				
		if(bean == null){
			System.out.println("no rows were found");
		}else{
			System.out.println("AdminId: "+ bean.getAdminId());
			System.out.println("User Name: "+ bean.getUserName());
			System.out.println("password: " + bean.getPassword());
			
		}
		

	}

}
