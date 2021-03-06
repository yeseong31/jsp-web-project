<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.BoardDTO"%>
<!-- list.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
	request.setCharacterEncoding("UTF-8");
%>
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
				<a href="writeForm.jsp">글쓰기</a>
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
<%		List<BoardDTO> list = bdao.listBoard();
		if (list == null || list.size() == 0) { %>
			<tr>
				<td colspan="6">등록된 게시글이 없습니다.</td>
			</tr>
<%		    return;
		} else {
			for (BoardDTO dto : list) { %>
				<tr>
					<td><%=dto.getNum()%></td>
					<td><a href="content.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a></td>
					<td><%=dto.getWriter()%></td>
					<td><%=dto.getReg_date()%></td>
					<td><%=dto.getReadcount()%></td>
					<td><%=dto.getIp()%></td>
				</tr>
<% 			}
		} %>
	</table>
</div>
</body>
</html>
