<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="entry.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="jquery-3.3.1.min.js"></script>
<script src="index.js"></script>
<link rel="stylesheet" href="index.css">
<%@ include file="head.jsp"%>
<title>歌曲页面</title>
</head>
<% User user=(User)session.getAttribute("user");
  %>
<body>
<input type="hidden" class="value" value="<%=user.getName()%>">
	<div class="songInfo">
		<div class="songMid">
			<div class="songIntro"></div>
			<div class="song_comment">
				<h2>评论</h2>
				<a class="comment_number"><i class="commnet_image"></i> </a> <br>
				<textarea class="inputarea"></textarea>
				<br> <br>
				<button class="btn" disabled>发表评论</button>
				<br> <br>
				<div class="comment_head">
					<h3>精彩评论</h3>
					<div class="hot_comment">
						<ul class="comment__list">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
<script>
	
