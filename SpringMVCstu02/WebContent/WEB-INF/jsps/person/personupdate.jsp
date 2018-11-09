<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonUpdate Page</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath}/person/saveOrUpdate.action" 
		method="post" modelAttribute="person" enctype="multipart/form-data">
		<sf:hidden path="id"/> 
		<table border="1">
		<tr>
			<td>name</td>
			<td><sf:input path="name"/><sf:errors path="name"/></td>
		</tr>
		<tr>
			<td>age</td>
			<td><sf:input path="age"/><sf:errors path="age"/></td>
		</tr>
		<tr>
			<td>photo</td>
			<td><input type="file" name="photo"/></td>
		</tr>		
		<tr>
			<td><input type="submit"/></td>
		</tr>
		</table>
	</sf:form>
</body>
</html>