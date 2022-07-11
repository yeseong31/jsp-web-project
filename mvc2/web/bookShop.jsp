<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- bookShop.jsp -->
<html>
<head>
<title>도서 주문 페이지</title>
</head>
<body>
	<h1>도서 주문 페이지</h1>
	<form name="f" action="bookShop.do" method="post">
		<input type="hidden" name="command" value="ADD">
		<b>도서주문: </b>
		<select name="book">
			<option>어린왕자/생텍쥐페리/15000</option>
			<option>홍길동전/허균/25000</option>
			<option>죄와벌/톨스토이/20000</option>
			<option>동의보감/허준/30000</option>
		</select>
		<b>수량: </b>
		<input type="text" name="qty" size="2" value="1">
		<input type="submit" value="도서주문">
	</form>
	<hr color="red">
	<jsp:include page="cart.jsp"/>
	
</body>
</html>