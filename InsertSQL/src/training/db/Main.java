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
		
		AdminManager.dieplayAllRows();
		
		Admin bean = new Admin();
		bean.setUserName(InputHelper.getInput("User Name : "));
		bean.setPassword(InputHelper.getInput("Password: "));
		
		boolean result = AdminManager.insert(bean);
		
		if (result){
			System.out.println("New Row with Primary Key " + bean.getAdminId());
		}
		
		

	}

}
