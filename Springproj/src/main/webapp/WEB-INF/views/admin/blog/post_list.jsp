<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_list.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">게시물 관리 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col" class="text-center">#</th>
                    <th scope="col" class="text-center">카테고리</th>
                    <th scope="col" class="text-center">제목</th>
                    <th scope="col" class="text-center">작성자</th>
                    <th scope="col" class="text-center">수정 / 삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty post_list}">
                    <tr>
                        <td colspan="5">등록된 게시물이 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="post" items="${post_list}">
                    <tr>
                        <td class="text-center">${post.id}</td>
                        <td class="text-center">${post.category}</td>
                        <td class="text-center"><a href="<c:url value="/admin/blog/post_detail?id=${post.id}"/>">${post.title}</a></td>
                        <td class="text-center">${post.author}</td>
                        <td class="text-center">
                            <button type="button" class="btn btn-outline-secondary btn-sm"
                                    onclick="location.href='/admin/blog/post_update?id=${post.id}'">수정</button>
                            <button class="btn btn-outline-danger flex-shrink-0 btn-sm" type="button"
                                    style="margin-right: 5px" onclick="location.href='/admin/blog/post_delete?id=${post.id}'">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='/admin/'">관리자 홈</button>
        <button type="button" class="btn btn-outline-dark" onclick="location.href='/admin/blog/post_write'">등록</button>
    </div>
</section>

<%@ include file="../../bottom.jsp" %>
