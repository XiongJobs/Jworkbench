<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8"%>
<%@ page errorPage="Error.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<p> Frome eclipse jsp</p>
	<% out.println("this is java print");
	/*    String s="sss";
	   int i=Integer.parseInt(s);
	   out.println(i);  */
	    %>
	<tr><td><%@ include file="inner.jsp" %></td></tr><!--编译指令不能在url中传递参数 -->
	<tr><td><jsp:include page="inner.jsp" flush="true"/></td></tr>
</body>
</html>