<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
	var url = "ws://127.0.0.1:8080/WebSocketStu/ChatServer?talker=${username}";
	var ws;
	
	if('WebSocket' in window){
		ws = new WebSocket(url);
	}
	else{
		alert('该浏览器不支持websocket');
	}
	
	
	function sendmsg(){
		var chat = document.getElementById('chat');
		var msg = '${username}说:' + chat.value;
		//alert(msg);
		
		ws.send(msg);
	}
	
	ws.onmessage = function(event){
		//alert(event.data);
		var contexts = document.getElementById('contexts');
		contexts.innerHTML += event.data + "\n";
	}
	
	ws.onclose = function(event){
	}
	
	ws.onerror = function(event){
	}
	
	</script>
	

  </head>
  
  <body>
   	<textarea rows="30" cols="100" id="contexts">
   	
   	</textarea>
   	<br><br>
   	<input type="text" id="chat">
   	<br><br>
   	<input type="button" value="发送" onclick="sendmsg()">
   	
  </body>
</html>
