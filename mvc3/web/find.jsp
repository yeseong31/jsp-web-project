<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, student.*"%>
<!-- find.jsp -->
<html>
<body>
    <div align="center">
		<hr color="green" width="300">
		<h2>학 생 목 록 보 기</h2>
		<hr color="green" width="300">
		<table border="1" width="500" >
			<tr>
				<td>아이디</td>
				<td>학생명</td>
				<td>학급명</td>
			</tr>
<%
	request.setCharacterEncoding("UTF-8"); 
	String name = request.getParameter("name");
	
	if(name==null||name.trim().equals("")) { 
		response.sendRedirect("student.jsp"); 
		return;
	}
	
	List<StudentDTO> list = (List)request.getAttribute("find");
	if(list == null || list.size() == 0) {
%>	
		<tr>
			<td colspan="3"><%=name %>학생은 없습니다.</td>
		</tr>
<%	} else {
		for(StudentDTO dto : list) {
%>	<tr>
		<td><%=dto.getId() %></td>
		<td><%= dto.getName() %></td>
		<td><%= dto.getCname()%></td>
	</tr>
<%
		}
%>
	<tr>
		<td colspan="3">총 <%=list.size()%>명 있습니다.</td>
	</tr>
<%
	}
%>
</body>
</html>