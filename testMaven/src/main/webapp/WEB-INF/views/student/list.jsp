<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- list.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>학생보기</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 목 록 보 기</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>아이디</th>
				<th>학생명</th>
				<th>학급명</th>
			</tr>
		<c:if test="${empty listStudent}">
			<tr>
				<td colspan="3">등록된 학생이 없습니다.</td>
			</tr>	
		</c:if>	
		<c:forEach var="dto" items="${listStudent}">	
			<tr>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.cname}</td>
			</tr>				
		</c:forEach>
		</table>
	</div>
</body>
</html>


