<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_list.jsp -->
<%@ include file="../../top.jsp" %>

<div class="container">
    <h1 class="display-6 text-center">차량 종류</h1>
    <div class="row mt-4">
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col" class="text-center">#</th>
                <th scope="col" style="padding-left: 30px">이름</th>
                <th scope="col" class="text-center">코드</th>
                <th scope="col" class="text-center">수정 / 삭제</th>
            </tr>
            </thead>
            <tbody>
                <c:if test="${empty getCartypeList}">
                    <tr>
                        <td colspan="5">등록된 차종이 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="dto" items="${getCartypeList}">
                    <tr>
                        <td class="text-center">${dto.id}</td>
                        <td style="padding-left: 30px"><a href="<c:url value="/car/type_detail?id=${dto.id}"/>">${dto.name}</a></td>
                        <td class="text-center">${dto.code}</td>
                        <td class="text-center">
                            <button type="button" class="btn btn-outline-secondary btn-sm"
                                    onclick="location.href='/admin/car/type_update?id=${dto.id}'">수정</button>
                            <button type="button" name="delete_btn" class="btn btn-outline-danger btn-sm"
                                    onclick="location.href='/admin/car/type_delete?id=${dto.id}'">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <button type="button" class="btn btn-outline-dark" onclick="location.href='/admin/'">관리자 홈</button>
    <button type="button" class="btn btn-outline-dark" onclick="location.href='/admin/car/type_write'">등록</button>
</div>

<%@ include file="../../bottom.jsp" %>
