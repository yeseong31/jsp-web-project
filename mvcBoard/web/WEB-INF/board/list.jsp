<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.dto.*"%>
<!-- list.jsp -->
<%	List<BoardDTO> listBoard = (List)request.getAttribute("listBoard"); %>
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
				<a href="board_writeForm.do">글쓰기</a>
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
<%	if (listBoard == null || listBoard.size() == 0) { %>
		<tr>
			<td colspan="6">게시된 글이 없습니다.</td>
		</tr>
<% 	} else {
		for (BoardDTO dto : listBoard) { %>
			<tr>
				<td><%=dto.getNum()%></td>
				<td><a href="board_content.do?num=<%=dto.getNum()%>">
					<%=dto.getSubject()%>
				</td>
				<td><%=dto.getWriter()%></td>
				<td><%=dto.getReg_date()%></td>
				<td><%=dto.getReadCount()%></td>
				<td><%=dto.getIp()%></td>
			</tr>	
<%	 	} 
 	} %>
	</table>
</div>
</body>
</html>
