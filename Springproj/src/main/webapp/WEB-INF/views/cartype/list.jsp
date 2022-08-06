<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<%@ include file="../top.jsp" %>

<div class="container">
    <h1 class="display-6 text-center">차종 리스트</h1>
    <div class="row mt-4">
        <table class="table">
            <thead class="thead-light text-center">
            <tr>
                <th scope="col">#</th>
                <th scope="col">이름</th>
                <th scope="col">코드</th>
                <th scope="col">설명</th>
                <th scope="col">등록일</th>
                <th scope="col">수정/삭제</th>
            </tr>
            </thead>
            <tbody class="text-center">
                <c:if test="${empty listCartype}">
                    <tr>
                        <td colspan="6">등록된 차종이 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="dto" items="${listCartype}">
                    <tr>
                        <td>${dto.id}</td>
                        <td><a href="cartype_detail.do?id=${dto.id}">${dto.name}</a></td>
                        <td>${dto.code}</td>
                        <td>${dto.description}</td>
                        <td>${dto.regDate}</td>
                        <td>
                            <button type="button" class="btn btn-outline-secondary btn-sm"
                                    onclick="location.href='cartype_update.do?id=${dto.id}'">수정</button>
                            <button type="button" name="delete_btn" class="btn btn-outline-danger btn-sm"
                                    onclick="location.href='cartype_delete.do?id=${dto.id}'">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <button type="button" class="btn btn-outline-dark" onclick="location.href='cartype_write.do'">등록</button>
</div>

<%@ include file="../bottom.jsp" %>
