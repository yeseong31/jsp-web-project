<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- deleteForm.jsp -->
<%
  String num = request.getParameter("num");
  if (num == null || num.trim().equals("")) {
    response.sendRedirect("list.jsp");
    return;
  }
%>
<html>
<head>
  <title>글삭제</title>
</head>
<body>
  <div align="center">
    <b>글삭제</b><br/>
    <form name="f" action="deletePro.jsp" method="post">
      <input type="hidden" name="num" value="<%=num%>" />
      <table border="1" width="800px">
        <tr bgcolor="yellow">
          <th colspan="2">비밀번호를 입력해 주세요.</th>
        </tr>
        <tr>
          <th width="20%" bgcolor="yellow">비밀번호: </th>
          <td>
            <label>
              <input type="password" name="passwd">
            </label>
          </td>
        </tr>
        <tr>
          <td colspan="2" bgcolor="yellow" align="center">
            <input type="submit" value="글삭제">
            <input type="button" value="글목록" onclick="window.location='list.jsp'">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>