<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!-- login.jsp-->
<%@ include file="top.jsp"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function loginCheck(){
		if (f.id.value===""){
			alert("아이디를 입력해 주세요!!")
			f.id.focus()
			return
		}
		if (f.passwd.value===""){
			alert("비밀번호를 입력해 주세요!!")
			f.passwd.focus()
			return
		}
		document.f.submit()
	}
</script>
<%
	Cookie[] cks = request.getCookies();
	String value = null;
	if (cks != null || cks.length != 0){
		for (Cookie ck : cks) {
			String name = ck.getName();
			if (name.equals("saveId")) {
				value = ck.getValue();
				break;
			}
		}
	}
%>
<br>
<img src="img/bottom.gif" width=570 height="40" border="0" alt="">
<br>
<p>
	<img src="img/tm_login.gif" width=100 height="13" border="0"
		 align=center ALT="회원 로그인">
<form name="f" action="login_ok.jsp" method="post">
	<table width="60%" align="center" height="120">
		<tr>
			<td align="right" width="30%">
				<img src="img/id01.gif"
					 width="28" height="11" border="0" alt="아이디">&nbsp;&nbsp;
			</td>
			<td width="40%">
				<% if (value == null){%>
					<input type="text" name="id" tabindex="1">
				<% }else { %>
					<input type="text" name="id" tabindex="1" value="<%=value%>">
				<% } %>
			</td>
			<td rowspan="2" width="30%" valign="middle">
				<a href="javascript:loginCheck()">
					<img src="img/bt_login.gif" border="0" alt="로그인"  tabindex="3">&nbsp;&nbsp;<br>
				</a>
				<nobr>
					<%if (value==null){ %>
						<input type="checkbox" name="saveId">
					<% }else { %>
						<input type="checkbox" name="saveId" checked>
					<% } %>
					<font face="굴림" size="2">아이디 기억하기</font>
				</nobr>
			</td>
		</tr>
		<tr>
			<td align="right">
				<img src="img/pwd.gif"
					 width="37" height="11" alt="비밀번호">
			</td>
			<td>
				<input type="password" name="passwd"  tabindex="2">
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<img src="img/bt_join.gif" width="60" height="22" alt="회원가입">
				<img src="img/bt_search_id.gif" width="60" height="22" alt="아이디 찾기">
				<img src="img/bt_search_pw.gif" width="60" height="22" alt="비밀번호 찾기">

			</td>
		</tr>
	</table>
</form>
<%@ include file="bottom.jsp"%>