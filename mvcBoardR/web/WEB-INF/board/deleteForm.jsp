<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- deleteForm.jsp -->
<html>
<head>
  <title>글삭제</title>
</head>
<body>
  <div align="center">
    <b>글삭제</b><br/>
    <form name="f" action="board_deletePro.do" method="post">
      <input type="hidden" name="num" value="${param.num}" />
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
            <input type="button" value="글목록" onclick="window.location='board_list.do'">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>