<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Index Page</title>
</head>
<body>
	<h2>log admin</h2>
	<form method="post" action="<%= request.getContextPath()%>/viewAll" >
	   	用户名：<input type="text" name="name"><br><br>
		密码：    <input type="text" name="pwd"><br><br>
		登录：    <input type="submit"/>
	</form><br><br>
</body>
</html>
