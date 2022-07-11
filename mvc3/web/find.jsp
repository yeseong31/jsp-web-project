<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<c:if test="${empty name}">
				<c:redirect url="student.jsp"/>
			</c:if>
			<c:if test="${empty find}">
			<tr>
				<td colspan="3">등록된 학생이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="${find}">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.name}</td>
					<td>${dto.cname}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">총 ${find.size()}명 있습니다.</td>
			</tr>
		</table>
	</div>
</body>
</html>