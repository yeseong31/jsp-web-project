<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- updatePro.jsp -->
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bdto" class="board.BoardDTO"/>
<jsp:setProperty name="bdto" property="*"/>
<jsp:useBean id="bdao" class="board.BoardDAO"/>
<%
    if (bdto.getWriter() == null || bdto.getWriter().trim().equals("")) {
        response.sendRedirect("list.jsp");
        return;
    }
    int res = bdao.updateBoard(bdto);
    if (res > 0) { %>
        <script type="text/javascript">
            alert("게시글 수정 성공!! 게시글 상세 페이지로 이동합니다.")
            location.href="content.jsp?num=<%=bdto.getNum()%>"
        </script>
<%	} else if (res < 0) { %>
    <script type="text/javascript">
        alert("잘못된 비밀번호입니다.")
        location.href = "updateForm.jsp?num=" + <%=bdto.getNum()%>
    </script>
<%	} else { %>
        <script type="text/javascript">
            alert("게시글 수정 실패!! 게시글 상세 페이지로 이동합니다.")
            location.href="content.jsp?num=<%=bdto.getNum()%>"
        </script>
<%	} %>

