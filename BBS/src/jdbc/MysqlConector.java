package jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConector {
	private static Connection con=null;
	
	public static Connection getConnection() {
		try {
			if(null ==con || con.isClosed()) {

				try {
					Constructor cos=Class.forName("com.mysql.jdbc.Driver").getConstructor(null);
					cos.newInstance();
				    con= DriverManager.getConnection("jdbc:mysql://localhost/"
							+ "bbs?useSSL=false&user=root&password=123456");
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
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Statement getStatement(Connection con) {
		Statement stat=null;
		
		if(null!=con) {
			try {
				stat=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return stat;
	}
	
	public static PreparedStatement getPrepStatement(Connection con,String sql) {
		PreparedStatement prstat=null;
		
		if(null!=con && null!=sql && ""!=sql) {
			try {
				prstat=con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return prstat;
	}
	public static PreparedStatement getPrepStatement(Connection con,String sql,int auto) {
		PreparedStatement prstat=null;
		
		if(null!=con && null!=sql && ""!=sql) {
			try {
				prstat=con.prepareStatement(sql,auto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return prstat;
	}
	
	public static ResultSet getResult(Statement sata,String sql) {
		ResultSet result=null;
		
		if(sata!=null && sql!=null) {
			try {
				result=sata.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static int executeUpdate(Connection con,String sql) {
		int exn=0;
		Statement sta=null;
		
		if(con!=null && sql!=null) {
			try {
				
				sta=con.createStatement();
				exn=sta.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBClose.close(sta);
			}
		}
		return exn;
		
	}
}
