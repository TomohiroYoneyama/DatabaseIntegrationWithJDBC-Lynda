package db.tables;
import training.db.*;
import training.db.beans.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminManager {
	
	public static void dieplayAllRows() throws SQLException {
		String sql = "SELECT adminId, userName, password FROM admin";
		
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
	
			){
			
			System.out.println("Admin Table");
			
			while(rs.next()){
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("adminId") + ": ");
				bf.append(rs.getString("userName") + ": ");
				bf.append(rs.getString("password"));
				System.out.println(bf.toString());
				
			}
		}
		
	}
	
	public static Admin getRow(int adminId) throws SQLException{
		String sql = "SELECT * FROM admin WHERE adminID = ?";
		ResultSet rs = null;
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, adminId);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				Admin bean = new Admin();
				bean.setAdminId(adminId);
				bean.setUserName(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				return bean;
			}else{
				System.err.println("no rows were found");
				return null;
			}
			
		}catch(SQLException e){
			return null;
		}finally{
			if(rs != null){
				rs.close();
			}
		}
		
	}
	
	public static boolean insert(Admin bean) throws Exception{
		String sql = "INSERT into admin (userName, password) " +
	                 "VALUES(?, ?)";
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(
						sql,
						Statement.RETURN_GENERATED_KEYS);
				
				){
			
		}catch(SQLException e){
			System.err.println(e);
			return false;
		}finally{
			
		}
		return true;
	}
	
	

}
