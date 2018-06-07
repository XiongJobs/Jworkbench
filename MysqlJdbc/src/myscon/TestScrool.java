package myscon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScrool {
	//结果集自由滚动
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=getcon(url,user,password);
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//创建结果可回滚并发只读的statement
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select * from student");
			rs.next();
			System.out.println(rs.getInt(1)); //打印第一个字段
			rs.last();    //指针定位到最后一行
			System.out.println(rs.getString(1));  //打印第一个字段的string类型数据
			System.out.println(rs.isLast());   //查看指针是否在最后一个记录
			System.out.println(rs.isAfterLast()); //查看指针是否在倒二条记录
			System.out.println(rs.getRow());   //查看指针在第几条记录
			rs.previous();        //指针向前移动一行
			System.out.println(rs.getString(2));  //查看第二个字段的string类型数据
			rs.absolute(3);             //指针跳到第三条记录
			System.out.println(rs.getString(1));
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
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				st=null;
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
