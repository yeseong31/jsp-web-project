<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!-- memberSsn.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<hr color="green" width="300">
	<h2>회 원 가 입 유 무 </h2>
	<hr color="green" width="300">
	<form name="f" action="member_check.do" method="post">
		<table border="1" width="500">
			<tr>
				<th width="20%">이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th width="20%">주민등록번호</th>
				<td><input type="text" name="ssn1">
					- <input type="password" name="ssn2">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="조회">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>