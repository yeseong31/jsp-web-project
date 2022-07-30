<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!-- top.jsp -->
<html>
<head>
	<title>회원관리</title>
</head>
<%
	boolean isLogin = false;
	String mbId = (String) session.getAttribute("mbId");
	if (mbId != null) isLogin = true;
%>
<body>
<div align="center">
	<table border="1" width="600" height="500">
		<tr height="10%">
			<th>
				<% if (isLogin) { %>
					<a href="logout.jsp">로그아웃</a>
				<% } else { %>
					<a href="login.jsp">로그인</a>
				<% } %>
			</th>
			<th><a href="memberSsn.jsp">회원가입</a></th>
			<th><a href="memberAll.jsp">회원보기</a></th>
			<th><a href="memberAll.jsp?mode=find">회원찾기</a></th>
		</tr>
		<tr height="80%">
			<td width="100%" height="100%" colspan="4">