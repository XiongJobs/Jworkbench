package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Message;
import db.DBaccess;

/**
 *��Message层
 *
 */
public class MessageDao {
	
	//查询列表(jdbc)
	public List<Message> queryMessageList(String command,String discription) {
		List<Message> messageList=new ArrayList<Message>();
		try {
			Class Mjdbc=Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1/micro_message?useUnicode=true&characterEncoding=utf-8&useSSL=true";
			Connection conn=DriverManager.getConnection(url, "root", "123456");
			
			StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
			
			List<String> paramList=new ArrayList<String>();
			if(command !=null &&!"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}			
			if(discription !=null &&!"".equals(discription.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(discription);
			}	
			
			PreparedStatement preps=conn.prepareStatement(sql.toString());
			
			for(int i=0;i<paramList.size();i++) {
				preps.setString(i+1, paramList.get(i));
			}
			
			ResultSet rs=preps.executeQuery();						
			while(rs.next()) {
				Message message=new Message(rs.getString("ID"),rs.getString("COMMAND"),
						rs.getString("DESCRIPTION"),rs.getString("CONTENT"));
				
				messageList.add(message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messageList;
	}
	
	//查询列表(Mybatis)
	public List<Message> queryMessageList2(String command,String discription) {
		List<Message> messageList=new ArrayList<Message>();
		
		DBaccess dbAccess=new DBaccess();
		SqlSession sqlSession=dbAccess.getSqlSession();
		
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(discription);
		
		//条件查询（不通过接口）
	//	messageList=sqlSession.selectList("Message.queryMessageList",message);

		//通过sqlSessio获得message.xml代理接口imessage
		IMessage imessage=sqlSession.getMapper(IMessage.class);  
		
		//条件查询（通过接口）
		messageList=imessage.queryMessageList(message);
		
		if(sqlSession != null) {sqlSession.close();}
		
		return messageList;
		
	}
	
	//通过Mybatis拦截器实现分页拦截显示功能
	public List<Message> queryMessageListByPage(Map <String,Object> parameter){
		DBaccess dbAccess=new DBaccess();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession=dbAccess.getSqlSession();
		IMessage imessage=sqlSession.getMapper(IMessage.class);
		messageList=imessage.queryMessageListByPage(parameter);
		
		if(sqlSession != null) {sqlSession.close();}
		return messageList;
	}
	
	
	
	//单个删除
	public void deleteOne(int id) {
		DBaccess dbAccess=new DBaccess();
		SqlSession sqlSession=dbAccess.getSqlSession();
		
		int den=sqlSession.delete("Message.deleteOne",id);
		sqlSession.commit();
		
		if(sqlSession != null) {sqlSession.close();}
	}
	
	//批量删除
	public void deleteBatch(List <Integer> ids) {
		DBaccess dbAccess=new DBaccess();
		SqlSession sqlSession=dbAccess.getSqlSession();
		
		sqlSession.delete("Message.deleteBatch",ids);
		sqlSession.commit();
		
		if(sqlSession != null) {sqlSession.close();}
	}
	
}
