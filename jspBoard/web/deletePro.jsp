<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- deletePro.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO" />
<%
	String num = request.getParameter("num");
	String passwd = request.getParameter("passwd");
	if (num == null || num.trim().equals("") || 
			passwd==null || passwd.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}	
	int res = bdao.deleteBoard(Integer.parseInt(num), passwd);
	if (res > 0) { %>
	<script type="text/javascript">
		alert("게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.")
		location.href = "list.jsp"
	</script>	
<%	} else if (res < 0) { %>
	<script type="text/javascript">
		alert("잘못된 비밀번호입니다.")
		location.href = "content.jsp?num=" + <%=num%>
	</script>
<%	} else { %>
	<script type="text/javascript">
		alert("게시글 삭제 실패!! 게시글 목록 페이지로 이동합니다.")
		location.href = "list.jsp"
	</script>	
<%	} %>
