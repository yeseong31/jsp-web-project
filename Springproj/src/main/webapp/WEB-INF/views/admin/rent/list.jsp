<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">예약 관리 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col" class="text-center">#</th>
                    <th scope="col" style="padding-left: 30px">사용자</th>
                    <th scope="col" class="text-center">차량인수일</th>
                    <th scope="col" class="text-center">반납완료</th>
                    <th scope="col" class="text-center">수정 / 삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty list}">
                    <tr>
                        <td colspan="5">등록된 차량이 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="dto" items="${list}">
                    <tr>
                        <td class="text-center">${dto.id}</td>
                        <td style="padding-left: 30px"><a href="#">${dto.userid}</a></td>
                        <td class="text-center">${dto.acceptance_date}</td>
                        <td class="text-center">${dto.is_return}</td>
                        <td class="text-center">
                            <button type="button" class="btn btn-outline-secondary btn-sm"
                                    onclick="location.href='#'">수정</button>
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
