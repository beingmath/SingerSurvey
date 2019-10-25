<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="index.css">
<title>我爱听音乐</title>
</head>
<body>
<div class="content">
<div class="center">
<h2>我爱听音乐</h2>
<br>
<form style="display:inline" method="post" action="Login">
       username：<input type="text" style="width:200px;height:30px;background:none" name="name" ></br></br></br></br></br>
     password：<input type="password" style="width:200px;height:30px;background:none" name="password"></br></br></br></br>
</select></br></br></br></br></br>
<input type="submit" value="登录" style="margin-left:70px;display:inline"> 

</form>
<button class="but" style="margin-left:20px">立即注册</button>
</div>
</div>
</body>
<script>
$(function(){
  $(".but").click(function(){
	  window.location.href="register.html";
  });
})
</script>
</html>