<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- member_input.jsp -->
<%@ include file="top.jsp" %>

<%
  request.setCharacterEncoding("UTF-8");
  String name = request.getParameter("name");
  String ssn1 = request.getParameter("ssn1");
  String ssn2 = request.getParameter("ssn2");

  if (name == null || name.trim().equals("") ||
          ssn1 == null || ssn1.trim().equals("") ||
          ssn2 == null || ssn2.trim().equals("")) {
    response.sendRedirect("index.jsp");
    return;
  }
%>

<div align="center">
  <form name="f" action="member_input_ok.jsp" method="post" onsubmit="return check()">
    <table border="1" width="80%">
      <tr>
        <th>이름</th>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <th>아이디</th>
        <td><input type="text" name="id" value="<%=name%>" readonly></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="passwd"></td>
      </tr>
      <tr>
        <th>주민등록번호</th>
        <td>
          <input type="text" name="ssn1" value="<%=ssn1%>" readonly>-<input type="password" name="ssn2" value="<%=ssn2%>" readonly>
        </td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td>
          <input type="text" name="hp1" size="3" maxlength="3">
          -<input type="text" name="hp2" size="4" maxlength="4">
          -<input type="text" name="hp3" size="4" maxlength="4">
        </td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="text" name="email"></td>
      </tr>
      <tr>
        <td align="center">
          <input type="submit" value="회원가입">
          <input type="reset" value="다시 입력">
        </td>
      </tr>
    </table>
  </form>
</div>
<script type="text/javascript">
  function check() {
    if (f.id.value==="") {
      alert("아이디를 입력해 주세요!!")
      f.id.focus()
      return false
    } else if (f.passwd.value==="") {
      alert("비밀번호를 입력해 주세요!!")
      f.passwd.focus()
      return false
    }
    return true
  }
</script>
<%@ include file="bottom.jsp" %>
