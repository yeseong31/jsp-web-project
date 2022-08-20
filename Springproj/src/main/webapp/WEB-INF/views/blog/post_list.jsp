<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_list.jsp -->
<%@ include file="../top.jsp" %>
<!-- Main Contents -->
<div class="container my-3">
    <div class="row">
        <div class="col-md-8 col-lg-9" id="main-area">
            <div>
                <h1>게시판
                    <a id="category-badge" class="badge rounded-pill bg-secondary text-decoration-none link-light">${category.name}</a>
                </h1>
            </div>
            <c:forEach var="p" items="${post_list}">
                <!-- Blog Post -->
                <div class="card mb-4">
<%--                    <img class="card-img-top" src="https://picsum.photos/seed/${ p.id }/800/400" alt="random image">--%>
                    <div class="card-body">
                        <!-- Category -->
                        <span class="badge badge-secondary float-right">${ p.category }</span>
                        <h2 class="card-title">${ p.title }</h2>
                        <c:if test="${not empty p.hook_text}">
                            <h5 class="text-muted">${ p.hook_text }</h5>
                        </c:if>
                        <p class="card-text">${ p.content }</p>
                        <a href="<c:url value="/blog/detail?id=${p.id}"/>" class="btn btn-outline-dark">질문 상세 조회 &rarr;</a>
                    </div>
                    <div class="card-footer text-muted">
                        Posted on ${ p.create_at.year }/${ p.create_at.monthValue }/${ p.create_at.dayOfMonth }
                        <c:if test="${not empty p.author}">
                            by ${ p.author }
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${empty post_list}">
                <div class="card mb-4" id="post-${ p.id }">
                    <div class="card-body">
                        <h3>아직 게시물이 없습니다.</h3>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="col-md-4 col-lg-3">
            <!-- Search Widget -->
            <%@ include file="category_widget.jsp" %>
        </div>
    </div>
</div>
<%@ include file="../bottom.jsp" %>