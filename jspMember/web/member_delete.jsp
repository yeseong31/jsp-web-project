<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- member_delete.jsp -->
<jsp:useBean id="mbdao" class="member.MemberDAO"/>
<%
    request.setCharacterEncoding("UTF-8");
    String no = request.getParameter("no");
    if (no == null || no.trim().equals("")) { %>
        <script type="text/javascript">
            alert("회원 정보가 전달되지 않았습니다.")
            history.back()
        </script>
<%		return;
    }
    int res = mbdao.deleteMember(Integer.parseInt(no));
    if (res > 0) { %>
        <script type="text/javascript">
            alert("회원 삭제 성공!! 회원 목록 페이지로 이동합니다.")
            location.href="memberAll.jsp"
        </script>
        <%	} else { %>
        <script type="text/javascript">
            alert("회원 삭제 실패!! 회원 목록 페이지로 이동합니다.")
            location.href="memberAll.jsp"
        </script>
<%	} %>
