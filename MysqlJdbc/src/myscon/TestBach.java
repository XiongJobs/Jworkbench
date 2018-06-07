package myscon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestBach {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=getcon(url,user,password);
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			stmt= con.createStatement();
			stmt.addBatch("INSERT student (stuname) VALUES('pi1')");
			stmt.addBatch("INSERT student (stuname) VALUES('pi2')");
			stmt.addBatch("INSERT student (stuname) VALUES('pi3')");
			stmt.executeBatch();
			
			ps=con.prepareStatement("INSERT student (id,stuname) VALUES(?,?)");
			ps.setInt(1, 100);
			ps.setString(2, "pri1");
			ps.addBatch();
			ps.setInt(1, 101);
			ps.setString(2, "pri2");
			ps.addBatch();
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps=null;
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con=null;
			}
		}

	}

	public static Connection getcon(String url,String user,String password) {	
	    Connection conne=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		return conne;		
	}
}

/*为了实现如转账问题前后不一致问题可以先将自动提交设为false
 * con.setAutoCommit(false);
		执行语句
   con.commit();  提交sql语句
         在报错 catch 中 回滚  con.rollback();
   con.setAutoCommit(true);   再将自动提交语句重新设为true
    
*/