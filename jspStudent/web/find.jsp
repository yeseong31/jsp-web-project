<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, student.*"%>
<!-- find.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
%>
<html>
<head>
	<title>학생 찾기</title>
</head>
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2><%=name %> 학 생 검 색 결 과</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>아이디</th>
				<th>학생명</th>
				<th>학급명</th>
			</tr>
<%
		 	List<StudentDTO> list = stdao.findStudent(name);
		 	if (list == null || list.size() == 0) {
		 		// response.sendRedirect("student.jsp");
		 		// return; %>
		 		<tr>
		 			<td colspan="3">해당 이름의 학생이 없습니다.</td>
		 		</tr>	
<%			} else {
				for (StudentDTO dto: list) { %>
				<tr>
					<td><%=dto.getId() %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getCname() %></td>
				</tr> 
<%				}
  			} %>
			<tr>
				<td colspan="3">총 <%=list.size()%>명</td>
			</tr>
		</table>
	</div>
</body>
</html>