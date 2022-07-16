<%@ page import="board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- updateForm.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
  request.setCharacterEncoding("UTF-8");
  String num = request.getParameter("num");
  if (num == null || num.trim().equals("")) {
    response.sendRedirect("list.jsp");
    return;
  }
  BoardDTO dto = bdao.getBoard(Integer.parseInt(num), "update");
%>
<html>
<head>
  <title>글수정</title>
</head>
<body>
<div align="center">
  <b>글수정</b><br/><br/>
  <form name="f" action="updatePro.jsp" method="post" onsubmit="return checkBoard()">
    <input type="hidden" name="num" value="<%=dto.getNum()%>">
    <table border="1" width="800px">
      <tr bgcolor="yellow">
        <th colspan="2">글 쓰 기</th>
      </tr>
      <tr>
        <th width="20%" bgcolor="yellow">이 름</th>
        <td><input type="text" name="writer" value="<%=dto.getWriter()%>" readonly></td>
      </tr>
      <tr>
        <th width="20%" bgcolor="yellow">제 목</th>
        <td><input type="text" name="subject" value="<%=dto.getSubject()%>"></td>
      </tr>
      <tr>
        <th width="20%" bgcolor="yellow">Email</th>
        <td><input type="text" name="email"  value="<%=dto.getEmail()%>"></td>
      </tr>
      <tr>
        <th width="20%" bgcolor="yellow">내 용</th>
        <td>
          <label>
            <textarea name="content" rows="8" cols="50"><%=dto.getContent()%></textarea>
          </label>
        </td>
      </tr>
      <tr>
        <th width="20%" bgcolor="yellow">비밀번호</th>
        <td><input type="password" name="passwd"></td>
      </tr>
      <tr>
        <td colspan="2" bgcolor="yellow" align="center">
          <input type="submit" value="글수정">
          <input type="reset" value="다시작성">
          <input type="button" value="목록보기" onclick="window.location='board_list.do'">
        </td>
      </tr>
    </table>
  </form>
</div>

<!-- 유효성 검사 -->
<script type="text/javascript">
  function checkBoard(){
    if (f.writer.value===""){
      alert("이름을 입력하세요")
      f.writer.focus()
      return false;
    }
    if (f.subject.value===""){
      alert("제목을 입력하세요")
      f.subject.focus()
      return false;
    }
    if (f.content.value===""){
      alert("내용을 입력하세요")
      f.content.focus()
      return false;
    }
    if (f.passwd.value===""){
      alert("비밀번호를 입력하세요")
      f.passwd.focus()
      return false;
    }
    return true;
  }
</script>

</body>
</html>