<%@ page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- member_input_ok.jsp -->
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mbdto" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="mbdto" />
<jsp:useBean id="mbdao" class="member.MemberDAO"/>
<%
    if (mbdto.getName() == null || mbdto.getName().trim().equals("")) {
        response.sendRedirect("index.jsp");
        return;
    }
    int res = 0;
    try {
        res = mbdao.insertMember(mbdto);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    if (res > 0) { %>
        <script type="text/javascript">
            alert("회원가입 성공!! 회원 관리 페이지로 이동합니다.")
            location.href="index.jsp"
        </script>
<%	} else { %>
        <script type="text/javascript">
            alert("회원가입 실패!! 회원 등록 페이지로 이동합니다.")
            location.href="member_input.jsp"
        </script>
<%	} %>