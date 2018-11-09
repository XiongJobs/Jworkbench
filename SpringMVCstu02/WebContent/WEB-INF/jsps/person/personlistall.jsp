<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonList</title>
</head>
<body>
	<table border="1">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>age</td>
		<td colspan="2">操作</td>
		<td>photo</td>
	</tr>
	<c:forEach items="${personList}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.age}</td>
			<td><a href="${pageContext.request.contextPath}/person/toupdate.action?id=${p.id}">修改</a></td>
			<td><a href="${pageContext.request.contextPath}/person/delete.action?id=${p.id}">删除</a></td>
			<td><img src="${pageContext.request.contextPath}${p.photopath}"/></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/person/tocreate.action">新增</a>
</body>
</html>