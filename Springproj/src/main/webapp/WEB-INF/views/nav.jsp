<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <img src="https://user-images.githubusercontent.com/66625672/183276264-2d5aa8de-6e43-4c73-97b2-fc16f2d3fe20.png"
             style="width: 100px; margin-right: 50px" alt="logo1" onclick="location.href='/'">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/"/>">홈으로</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/car/rent"/>">예약</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/car/type_list"/>">차량(종류)</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="#"/>">내 정보</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="#"/>">게시판</a>
                </li>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"--%>
<%--                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                        About--%>
<%--                    </a>--%>
<%--                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
<%--                        <a class="dropdown-item" href="#">서비스</a>--%>
<%--                        <a class="dropdown-item" href="#">위치</a>--%>
<%--                        <a class="dropdown-item" href="#">FAQ</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/common/sign_in'/>">로그인</a>
                </li>
            </ul>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item">--%>
<%--                    <form name="f" action="<c:url value="/common/logout"/>" method="post">--%>
<%--                        <button class="nav-link" style="text-align: left; width: 100%; border: 0; outline: 0; background-color: #f8f9fa">로그아웃</button>--%>
<%--                        <label><input name="${_csrf.parameterName}" value="${_csrf.token}" hidden/></label>--%>
<%--                    </form>--%>
<%--                </li>--%>
<%--            </ul>--%>
            <ul class="navbar-nav" style="">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/admin/"/>">관리자 페이지</a>
                </li>
            </ul>
        </div>
    </div>
</nav>