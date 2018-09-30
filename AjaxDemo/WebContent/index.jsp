<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
		var xhr;
		function getText() {
 /* 			$.ajax({
				type:"post",
				url:"Server1",
				data:'{"user":"weo"}',
				success:function(data){
					$('#msg').html(data);
				}
			});	 */
			
		//	 $('#msg').load('hello.txt'); 
			 $.get('Server1','user=tomy&job=student',function(data){
				 $('#msg').html(data); 
			 });
				 
			 
		}
		
		function refresh() {  
        	document.getElementById("imagecode").src = "ImageServlet?"+Math.random();  
   		} 
	</script>
  </head>
  
  <body>
    <input type="button" value="获取" onclick="getText()">&nbsp; &nbsp; <span id="msg"></span><br/>
   
<!--     <form action="LoginServlet" method="get" >
	   	 验证码:<input  type="text" name="checkCode"/>
	    <img alt="验证码" id="imagecode" src="ImageServlet"/>
	    <a href="#" onclick='refresh()'>看不清楚</a><br>
	    <input type="submit" value="提交">
    </form> -->
  </body>
</html>
