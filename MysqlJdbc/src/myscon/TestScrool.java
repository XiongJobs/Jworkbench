package myscon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScrool {
	//��������ɹ���
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/basdemo?useSSL=false";
		String user="root";
		String password="123456";
		String sql=null;
		
		Connection con=getcon(url,user,password);
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//��������ɻع�����ֻ����statement
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select * from student");
			rs.next();
			System.out.println(rs.getInt(1)); //��ӡ��һ���ֶ�
			rs.last();    //ָ�붨λ�����һ��
			System.out.println(rs.getString(1));  //��ӡ��һ���ֶε�string��������
			System.out.println(rs.isLast());   //�鿴ָ���Ƿ������һ����¼
			System.out.println(rs.isAfterLast()); //�鿴ָ���Ƿ��ڵ�������¼
			System.out.println(rs.getRow());   //�鿴ָ���ڵڼ�����¼
			rs.previous();        //ָ����ǰ�ƶ�һ��
			System.out.println(rs.getString(2));  //�鿴�ڶ����ֶε�string��������
			rs.absolute(3);             //ָ��������������¼
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
