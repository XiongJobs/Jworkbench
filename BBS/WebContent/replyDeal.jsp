<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*,java.util.*" %>
<%@ page import="jdbc.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	
	int pid = Integer.parseInt(request.getParameter("pid"));
	int rootId = Integer.parseInt(request.getParameter("rootId"));
	

	String title = request.getParameter("title");
	System.out.println(title);
	String cont = request.getParameter("cont");
	System.out.println(cont);
	Connection conn = MysqlConector.getConnection();
	
	boolean autoCommit = conn.getAutoCommit();
	conn.setAutoCommit(false);
	
	String sql = "insert into article values (null, ?, ?, ?, ?, now(), ?)";
	PreparedStatement pstmt = MysqlConector.getPrepStatement(conn, sql);
	pstmt.setInt(1, pid);
	pstmt.setInt(2, rootId);
	pstmt.setString(3, title);
	pstmt.setString(4, cont);
	pstmt.setInt(5, 0);
	pstmt.executeUpdate();
	
	Statement stmt = MysqlConector.getStatement(conn);
	stmt.executeUpdate("update article set isleaf = 1 where id = " + pid);
	
	conn.commit();
	conn.setAutoCommit(autoCommit);
	DBClose.close(pstmt);
	DBClose.close(stmt);
	DBClose.close(conn);

	//response.sendRedirect("Article.jsp");
 %>

<span id="time" style="background:red">5</span>秒钟后自动跳转，如果不跳转，请点击下面链接

<script language="JavaScript1.2" type="text/javascript">

//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
//alert(delay);
	if(delay > 0) {
		delay--;
		document.getElementById("time").innerHTML = delay;
	} else {
		window.top.location.href = url;
    }
    setTimeout("delayURL('" + url + "')", 1000); //delayURL(http://wwer)
}



</script>


<a href="Article.jsp">主题列表</a>
<script type="text/javascript">
	delayURL("A rticle.jsp");
</script>