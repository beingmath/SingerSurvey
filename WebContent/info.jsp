<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="service.SingerService"%>
<%@ page import="entry.*"%>
<%@ page import="entry.song"%>
<%@ page import="java.util.*"%>
<%@ page import="service.SongService"%>
<%@ page import="entry.Utils"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>歌手详情页面</title>
</head>
<body>
<%     
        ArrayList<song> songs=new ArrayList<song>();
       String mid=request.getParameter("id");
       Map<String,singer> map=Utils.getSingermap();
       singer singer=map.get(mid);
     songs=SongService.SelectSongBySid(mid);
			%>
	<div class="Isinger_info">
	<img class="image_info" src="<%=singer.getImage()%>">
			<div class="singername">
				<h1><%=singer.getInfo()%></h1>
			</div>
	</div>
	<div class="content-bottom">
		<ul id="ullist">
			<li class="list_title">
				<div class="number">全选</div>
				<div class="name">歌曲名</div>
				<div class="music">专辑</div>
				<div class="time">时长</div>
			</li>
			<a href="comment.jsp?id=<%=songs.get(0).getId()%>">
			<li class="list_title">
				<div class="number">1</div>
				<div class="name"><%=songs.get(0).getName() %></div>
				<div class="music"><%=songs.get(0).getAlbum() %></div>
				<div class="time"><%=songs.get(0).getTime() %></div>
			</li></a>
				<a href="comment.jsp?id=<%=songs.get(1).getId() %>">
			<li class="list_title">
				<div class="number">2</div>
				<div class="name"><%=songs.get(1).getName() %></div>
				<div class="music"><%=songs.get(1).getAlbum() %></div>
				<div class="time"><%=songs.get(1).getTime() %></div>
			</li></a>
				<a href="comment.jsp?id=<%=songs.get(2).getId() %>">
			<li class="list_title">
				<div class="number">3</div>
				<div class="name"><%=songs.get(2).getName()%></div>
				<div class="music"><%=songs.get(2).getAlbum() %></div>
				<div class="time"><%=songs.get(2).getTime() %></div>
			</li></a>
		</ul>
	</div>
	<h3 style="text-align:center;margin-top:-150px;">点击歌曲可以进行查看评论哦！！！！</h3>
</body>
</html>
