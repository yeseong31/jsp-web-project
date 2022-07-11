<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- delete.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="stdto" class="student.StudentDTO"/>
<jsp:setProperty property="*" name="stdto" />
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<%
	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) { %>
		<script type="text/javascript">
			alert("아이디를 입력해 주세요!!")
			history.back()
		</script>	
<%		return;
	}
	int res = stdao.deleteStudent(id);
	if (res > 0) { %>
		<script type="text/javascript">
			alert("학생 삭제 성공!! 학생 목록 페이지로 이동합니다.")
			location.href="list.jsp"
		</script>	
<%	} else { %>
		<script type="text/javascript">
			alert("학생 삭제 실패!! 학생 관리 페이지로 이동합니다.")
			location.href="student.jsp"
		</script>
<%	} %>
