package myscon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Myprocedure {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=getcon(url,user,password);
		CallableStatement cs=null;  //用于调用存储过程
		ResultSet rs=null;
		
		
		try {
			cs=con.prepareCall("{call addnum(?,?,?)}");
			cs.registerOutParameter(3,Types.INTEGER); //设定第三个参数为返回值，返回类型为int
			
			cs.setInt(1, 3);  //设置第一个参数为3
			cs.setInt(2, 4);  //设置第二个参数为4
			
			cs.execute();
			
			System.out.println(cs.getInt(3));  //打印返回值，即第三个参数
			
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
			if(cs!=null) {
				try {
					cs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cs=null;
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
