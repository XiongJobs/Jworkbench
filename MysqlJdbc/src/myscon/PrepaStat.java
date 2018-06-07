package myscon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PrepaStat {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		con=getcon(url,user,password);
		
		sql="select * from student";		
		try {
			ps=con.prepareStatement(sql);			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("stuname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		}
		
		sql="INSERT student (stuname) VALUES(?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "hulala");
			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps=null;
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
