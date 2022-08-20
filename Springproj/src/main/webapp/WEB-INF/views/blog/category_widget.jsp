<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card my-4" id="categories-card">
    <h5 class="card-header">카테고리</h5>
    <div class="card-body">
        <div class="row">
            <ul class="list-unstyled mb-0">
                <c:forEach var="category" items="${categories}">
                    <li>
                        <a href="<c:url value="/blog?category=${category.id}"/>">${category.name}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="#">미분류 (링크 연결 아직 X)</a>
                </li>
            </ul>
        </div>
    </div>
</div>