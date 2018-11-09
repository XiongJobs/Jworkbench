package db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 *
 */
public class DBaccess {
	// mybatis squSession
	public SqlSession getSqlSession(){
		SqlSession sqlSession=null;
		try {
			
			Reader reader=Resources.getResourceAsReader("configers/Configuration.xml");
			
			//获取sqlSession工厂
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			//通过工厂获取sqlsession
			sqlSession=sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return sqlSession;
		}		
	}
}
