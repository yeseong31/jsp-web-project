<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="member.*" %>
<!-- login_ok.jsp-->
<jsp:useBean id="loginCheck" class="member.LoginCheck"/>
<jsp:setProperty name="loginCheck" property="*"/>
<%
    if (loginCheck.getId() ==  null || loginCheck.getId().trim().equals("")) {
        response.sendRedirect("login.jsp");
        return;
    }
    // 쿠키(Cookie)
    String saveId = request.getParameter("saveId");
    // 체크가 되어 있으면 on, 체크가 안 되어 있으면 null
    Cookie ck = new Cookie("saveId", loginCheck.getId());

    int res = loginCheck.checkLogin();
    String msg = null, url = null;
    switch (res) {
        case LoginCheck.OK -> {
            // 쿠키 유효 시간 설정 및 저장
            if (saveId != null) ck.setMaxAge(24*60*60);
            else ck.setMaxAge(0);
            response.addCookie(ck);
            // 세션에 아이디 저장
            session.setAttribute("mbId", loginCheck.getId());
            msg = "로그인이 되었습니다.";
            url = "index.jsp";
        }
        case LoginCheck.NOT_ID -> {
            msg = "존재하지 않는 아이디입니다. 다시 로그인 해 주세요.";
            url = "login.jsp";
        }
        case LoginCheck.NOT_PWD -> {
            msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요.";
            url = "login.jsp";
        }
        case LoginCheck.ERROR -> {
            msg = "DB 서버 오류 발생! 관리자에게 문의해 주세요.";
            url = "index.jsp";
        }
    }
%>
<script type="text/javascript">
    alert(<%=msg%>)
    location.href="<%=url%>"
</script>