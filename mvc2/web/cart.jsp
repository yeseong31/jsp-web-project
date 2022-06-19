<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, shop.*"%>
<!-- cart.jsp -->

<%
	List<BookDTO> list = (List)session.getAttribute("cart");
%>

<table border="1">
	<tr>
		<th>도서명</th>
		<th>저자</th>
		<th>가격</th>
		<th>수량</th>
		<th>삭제</th>
	</tr>
	
<%	if (list == null || list.size() == 0) { %>
		<tr>
			<td colspan="5">주문한 도서가 없습니다.</td>
		</tr>
<% 	} else {
	 	for (int i = 0; i < list.size(); i++) {
			BookDTO dto = list.get(i);	%>
			<tr>
				<td><%=dto.getTitle() %></td>
				<td><%=dto.getAuthor() %></td>
				<td><%=dto.getPrice() %></td>
				<td><%=dto.getQty() %></td>
				<td>
					<form name="del" method="post" action="bookShop.do">
						<input type="hidden" name="command" value="DEL">
						<input type="hidden" name="idx" value="<%=i%>">
						<input type="submit" value="삭제">
					</form>
				</td>
			</tr>	

<% 		} %>

	<tr>
		<td>
			<form method="post" action="bookShop.do">
				<input type="hidden" name="command" value="CHK">
				<input type="submit" value="결제 페이지로 이동">
			</form>
		</td>
	</tr>
<% 	} %>
</table>