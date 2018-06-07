package myscon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResult {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=getcon(url,user,password);
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//建立使结果集可更新的statement
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select * from student");
			rs.next();
			//更新一行数据
			rs.updateString("stuname", "luxi");
			rs.updateRow();
			
			//插入新的行
			rs.moveToInsertRow();
			rs.updateInt(1,200);
			rs.updateString("stuname", "lily");
			rs.insertRow();
			rs.moveToCurrentRow(); //将光标移动的新建的行
			
			//删除行
			rs.absolute(3);
			rs.deleteRow();
			
			//取消更新
			//rs.cancelRowUpdates();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
