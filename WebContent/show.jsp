<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="index.css">
<meta charset="utf-8">
<%@ include file="head.jsp"%>
<title>歌手查看</title>
</head>
<body>
<div class="img"></div>
<div class="mod_singer_list">
<ul class="usinger_list_item">
<li class="singer_list_item" name="a">
<a href="info.jsp?id=a">
<img class="singer_list__cover" src="image/a.jpg">
<h3 class="singer_title">  G.E.M. 邓紫棋</h3>
</a>
</li>
<li class="singer_list_item" name="b">
<a href="info.jsp?id=b">
<img class="singer_list__cover" src="image/b.jpg">
<h3 class="singer_title">  周杰伦</h3>
</a>
</li>
<li class="singer_list_item" name="c">
<a href="info.jsp?id=c">
<img class="singer_list__cover" src="image/c.jpg">
<h3 class="singer_title"> 李荣浩</h3>
</a>
</li>
<li class="singer_list_item" name="e">
<a href="info.jsp?id=e">
<img class="singer_list__cover" src="image/e.jpg">
<h3 class="singer_title">  陈奕迅</h3>
</a>
</li>
<li class="singer_list_item" name="f">
<a href="info.jsp?id=f">
<img class="singer_list__cover" src="image/f.jpg">
<h3 class="singer_title"> 张学友</h3>
</a>
</li>
<li class="singer_list_item" name="g">
<a href="info.jsp?id=g">
<img class="singer_list__cover" src="image/g.jpg">
<h3 class="singer_title">  BEYOND</h3>
</a>
</li>
<li class="singer_list_item" name="h">
<a href="info.jsp?id=h">
<img class="singer_list__cover" src="image/h.jpg">
<h3 class="singer_title">  张国荣</h3>
</a>
</li>
<li class="singer_list_item" name="i">
<a href="info.jsp?id=i">
<img class="singer_list__cover" src="image/i.jpg">
<h3 class="singer_title"> 刘德华</h3>
</a>
</li>
</ul>
</div>
<div class="down">点击歌手可以查看歌手信息，而且还能评论哦！！！</div>
</div>
</body>
</html>
