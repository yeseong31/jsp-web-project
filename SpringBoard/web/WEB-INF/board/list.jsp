<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- list.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>게시판</title>
</head>
<body>
<div align="center">
	<b>글 목 록</b>
	<table border="0" width="800px">
		<tr bgcolor="yellow">
			<td align="right">
				<a href="board_write.do">글쓰기</a>
			</td>
		</tr>	
	</table>
	<table border="1" width="800px">
		<tr bgcolor="green">
			<th>번호</th>
			<th width="30%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>IP</th>
		</tr>

		<!-- JSTL로 변경 -->
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">게시된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td>${dto.num}</td>
				<td><a href="board_content.do?num=${dto.num}">${dto.subject}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readCount}</td>
				<td>${dto.ip}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
