package test;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DBClose;
import jdbc.MysqlConector;

public class Tester {

	public static void main(String[] args) {
		Connection con=MysqlConector.getConnection();		
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery("select title from article");
			
			while(rs.next()) {
				System.out.println(rs.getString("title"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs);
			DBClose.close(stmt);
			DBClose.close(con);
		}
		
	}

}
