package db.tables;
import training.db.*;
import training.db.beans.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminManager {
	
	public static boolean delete(Admin bean) throws Exception{
		String sql = "DELETE FROM admin " +
	                 "where adminID = ?";
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
			){
			
		    stmt.setInt(1, bean.getAdminId());
			
			int affected = stmt.executeUpdate();
			
			if(affected ==1){
				return true;
				
			}else{
				return false;
			}
				
			}catch(SQLException e){
				System.err.println(e);
				return false;
			}
		}
		
	
	
	
	public static boolean update(Admin bean) throws Exception{
		String sql = "UPDATE admin SET " +
					 "userName = ?, password = ? " +
				     "WHERE adminID = ?";
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql)
			){
			stmt.setString(1, bean.getUserName());
			stmt.setString(2, bean.getPassword());
			stmt.setInt(3, bean.getAdminId());
			
			int affected = stmt.executeUpdate();
			if (affected ==1){
				return true;
			}else
				return false;
		}catch(SQLException e){
			System.err.println(e);
			return false;
		}
		
	
		
		
	}
	
	public static boolean insert(Admin bean) throws Exception{
		
		String sql = "INSERT into Admin (userName, password) " + 
		             "VALUES (?, ?)";
		ResultSet keys = null;
		
		try(
				Connection conn = DBUtility.getConnection(DBtype.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
			
				stmt.setString(1, bean.getUserName());
				stmt.setString(2, bean.getPassword());
				//this return number of rows affected
				int affected = stmt.executeUpdate();
				
				//provide integer primary key
				if(affected == 1){
					// return resultset 
					keys = stmt.getGeneratedKeys();
					
					
					// test
					//this print out that new primary key
					//System.out.println(keys.toString());
					
					
					keys.next();
					int newKey = keys.getInt(1);
					bean.setAdminId(newKey);
				}else {
					System.err.println("No wors are affected");
					return false;
				}
			
		}catch(SQLException e){
			System.err.println(e);
			return false;
		}finally{
			if(keys != null) keys.close();
		}
		return true;
	}
	

	
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

}
