<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#login').click(function(){
			
		var user={id:$("#uid").val(),pwd:$("#upwd").val()};  
			
/* 			for (var key in user) {
			    console.log(key);     //获取key值
			    console.log(user[key]); //获取对应的value值
			}  */
			
 			$.post("LoginServlet",JSON.stringify(user),function(data){
				//$("#answer").val(data);	
 				var json = eval('(' + data + ')');
 				$("#answer").val(json.pwd);
			}); 
		});
	});
</script>
</head>

<body>
	<form action="">
	   	<input type="text" id="uid"><br/><br/>
	   	<input type="password" id="upwd"><br/><br/>
	    <input type="button" value="提交" id="login"><br/><br/>
	    <input type="text" id="answer">返回的结果
    </form>
</body>
</html>