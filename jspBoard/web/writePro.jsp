<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- writePro.jsp -->
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
    int res = 0;
    try {
        bdto.setIp(request.getRemoteAddr());
        res = bdao.insertBoard(bdto);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    if (res > 0) { %>
        <script type="text/javascript">
            alert("게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.")
            location.href="list.jsp"
        </script>
<%	} else { %>
        <script type="text/javascript">
            alert("게시글 등록 실패!! 게시글 목록 페이지로 이동합니다.")
            location.href="list.jsp"
        </script>
<%	} %>
