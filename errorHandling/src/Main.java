import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM statesx";
		
		try{
			conn = DBUtility.getConnection(DBtype.HSQLDB);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("number of rows : " + rs.getRow());
			
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}finally{
			if (conn != null){
				conn.close();
			}
			if (stmt != null){
				stmt.close();
			}
			if (rs != null){
				rs.close();
			}
		}
		
		try{
			conn = DBUtility.getConnection(DBtype.MYSQL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("number of rows : " + rs.getRow());
			
			
		}catch(SQLException e){
			DBUtility.processException(e);
		}finally{
			if (conn != null){
				conn.close();
			}
			if (stmt != null){
				stmt.close();
			}
			if (rs != null){
				rs.close();
			}
		}

	}

}
