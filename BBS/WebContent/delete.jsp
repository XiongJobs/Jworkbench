<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*,java.util.*" %>
<%@ page import="jdbc.*,bean.*" %>

<%!
private void delete(Connection conn, int id, boolean isLeaf) {
	//delete all the children
	//delete(conn, chids's id)
	
	if(!isLeaf) { 
		String sql = "select * from article where pid = " + id;
		Statement stmt = MysqlConector.getStatement(conn);
		ResultSet rs = MysqlConector.getResult(stmt, sql); 
		try {
			while(rs.next()) {
				delete(conn, rs.getInt("id"), rs.getInt("isleaf") == 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(stmt);
		}
	}
	
	
	//delete self
	 MysqlConector.executeUpdate(conn, "delete from article where id = " + id);
	
	
}
%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	int pid = Integer.parseInt(request.getParameter("pid"));
	boolean isLeaf = Boolean.parseBoolean(request.getParameter("isLeaf"));
	//String url = request.getParameter("from");
	//System.out.println("url = " + url);
	Connection conn = null;
	boolean autoCommit = true;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		conn = MysqlConector.getConnection();
		autoCommit = conn.getAutoCommit();
		conn.setAutoCommit(false);
		
		delete(conn, id, isLeaf);
		
		stmt = MysqlConector.getStatement(conn);
		rs = MysqlConector.getResult(stmt, "select count(*) from article where pid = " + pid);
		rs.next();
		int count = rs.getInt(1);
		
		if(count <= 0) {
			MysqlConector.executeUpdate(conn, "update article set isleaf = 0 where id = " + pid);
		}
		
		conn.commit();
	} finally {
		conn.setAutoCommit(autoCommit);
		DBClose.close(rs);
		DBClose.close(stmt);
		DBClose.close(conn);
	}
	response.sendRedirect("Article.jsp");
%>
