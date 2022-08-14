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
                    <a class="nav-link" href="<c:url value="#"/>">게시판</a>
                </li>
                <c:if test="${empty userid}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/common/sign_in'/>">로그인</a>
                    </li>
                </c:if>
                <c:if test="${not empty userid}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="#"/>">내 정보(${userid})</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/common/logout'/>">로그아웃</a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav" style="">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/admin/"/>">관리자 페이지</a>
                </li>
            </ul>
        </div>
    </div>
</nav>