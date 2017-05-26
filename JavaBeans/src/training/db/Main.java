package training.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import db.tables.AdminManager;
import training.db.*;
import util.InputHelper;

public class Main {
	
	private static final String SQL = "{call GetToursWithCountByPrice(?,?)}";
	    //? is placeholder

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		AdminManager.displayAllRows();
		
		

	}

}
