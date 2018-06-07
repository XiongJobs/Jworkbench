package myscon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Connection1 {

	public static void main(String[] args) {
		try {
			Constructor cos=Class.forName("com.mysql.jdbc.Driver").getConstructor(null);
			cos.newInstance();
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/"
					+ "basdemo?useSSL=false&user=root&password=123456");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			
			while(rs.next()) {
				System.out.println(rs.getString("stuname"));
			}
			
			int b=stmt.executeUpdate("INSERT student (stuname) VALUES('Hulo')");
			System.out.println(b);
			
			if(rs !=null) {
				rs.close();
				rs=null;
			}
			if(stmt !=null) {
				stmt.close();
				stmt=null;
			}
			if(con !=null) {
				con.close();
				con=null;
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
