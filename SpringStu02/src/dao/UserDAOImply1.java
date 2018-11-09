package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;


import bean.User;

@Component("userDao")
public class UserDAOImply1 implements UserDAO {
	DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}
	
	@Resource(name="dataSource")
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public void save(User user) {
		
		try {
			Connection connection=datasource.getConnection();
			String sql="insert into User values(null,'jespa')";
			connection.createStatement().executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user saved!");		
	}


	
	
	
}
