<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!-- result.jsp -->
<%
	List<String> list = (List) request.getAttribute("advice");
	if (list == null || list.size() == 0) { %>
		<h2>준비된 데이터가 없습니다.</h2>
<%	} else { %>
		<h2>과목 선택에 따른 도움말</h2>
		<hr color="red">
		<% for (String msg : list) { %>
		<h2> <%=msg%> </h2>
<%  }%>
