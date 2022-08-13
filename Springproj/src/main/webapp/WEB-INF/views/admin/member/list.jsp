<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">사용자 관리 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col" style="padding-left: 30px">아이디</th>
                    <th scope="col" style="padding-left: 30px">이름</th>
                    <th scope="col" style="padding-left: 30px">이메일</th>
                    <th scope="col" class="text-center">삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty getMemberList}">
                    <tr>
                        <td colspan="5">등록된 사용자가 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="dto" items="${getMemberList}">
                    <tr>
                        <td style="padding-left: 30px"><a href="#">${dto.userid}</a></td>
                        <td style="padding-left: 30px">${dto.username}</td>
                        <td style="padding-left: 30px">${dto.email}</td>
                        <td class="text-center">
                            <button class="btn btn-outline-danger flex-shrink-0 btn-sm" type="button"
                                    style="margin-right: 5px" onclick="location.href='#'">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='/admin/'">관리자 홈</button>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='#'">등록</button>
    </div>
</section>

<%@ include file="../../bottom.jsp" %>
