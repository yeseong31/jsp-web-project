<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, shop.*"%>
<%
	Hashtable<String, BookDTO> result = (Hashtable)request.getAttribute("result");
	int totalQty = 0;
	int totalPrice = 0;
%>    

<!-- bookShopResult.jsp -->
<html>
<head>
<title>도서 구매 페이지</title>
</head>
<body>

<h1>도서 구매 페이지</h1>
<table border="1" width="500">
	<tr bgcolor="yellow">
		<th>도서명</th>
		<th>저자</th>
		<th>가격</th>
		<th>수량</th>
		<th>삭제</th>
	</tr>
<%
	Enumeration<String> enu = result.keys();
	while(enu.hasMoreElements()) {
		String title = enu.nextElement();
		BookDTO dto = result.get(title);%>
		<tr>
			<td><%=dto.getTitle() %></td>
			<td><%=dto.getAuthor() %></td>
			<td><%=dto.getPrice() %></td>
			<td><%=dto.getQty() %></td>
			<td><%=dto.getQty() * dto.getPrice() %></td>
		</tr>
	<%		
		totalQty += dto.getQty();
		totalPrice += dto.getQty() * dto.getPrice();
	} %>	
	<tr>
		<td colspan="3">총 계</td>
		<td><%= totalQty %></td>
		<td><%= totalPrice %></td>
	</tr>
</table>
	
</body>
</html>