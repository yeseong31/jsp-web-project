<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_list.jsp -->
<%@ include file="../top.jsp" %>
<!-- Main Contents -->
<div class="container my-3">
    <div class="row">
        <div class="col-md-8 col-lg-9" id="main-area">
            <!-- Post content-->
            <div id="post-area">
                <c:if test="${not empty category.name}">
                    <span class="badge badge-secondary float-right">${category.name}</span>
                </c:if>
                <c:if test="${empty category.name}">
                    <span class="badge badge-secondary float-right">미분류</span>
                </c:if>
                <article>
                    <!-- Post header-->
                    <header class="mb-4">
                        <!-- Post title-->
                        <h1 class="fw-bolder mb-1">${ post.title }</h1>
                        <c:if test="${not empty post.hook_text}">
                            <h5 class="text-muted">${ post.hook_text }</h5>
                        </c:if>
                        <!-- Post meta content-->
                        <div class="text-muted fst-italic mb-2">Posted on ${ post.create_at.year }/${ post.create_at.monthValue }/${ post.create_at.dayOfMonth }
                            <c:if test="${not empty post.author}"> by ${ post.author }</c:if>
                        </div>
                        <!-- Post categories-->
                        <a id="category-badge" class="badge bg-secondary text-decoration-none link-light" href="<c:url value="/blog?category=${category.id}"/>">${ category.name }</a>
                    </header>
                    <!-- Preview image figure-->
<%--                    <figure class="mb-4"><img class="img-fluid rounded" src="https://picsum.photos/seed/${ post.id }/800/400" alt="random image" /></figure>--%>
                    <!-- Post content-->
                    <section class="mb-5">
                        <p class="fs-5 mb-4">${ post.content }</p>
                    </section>
                </article>
            </div>
            <!-- Comments section-->
            <div id="comment-area">
                <section class="mb-5">
                    <div class="card bg-light">
                        <div class="card-body">
                            <!-- Comment form-->
                            <form method="post" class="mb-4" name="f" action="<c:url value="/blog/comment_write"/>" onsubmit="return checkBoard()">
                                <div class="form-group">
                                    <label for="content"></label>
                                    <textarea name="content" id="content" class="form-control"
                                              <c:if test="${empty userid}">disabled</c:if>
                                              placeholder="답글을 남겨 주세요!" style="resize: none"
                                              onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
                                </div><br>
                                <label><input name="post" value="${post.id}" hidden></label>
                                <label><input name="author" value="${userid}" hidden></label>
                                <input type="submit" value="답글 등록" class="register btn btn-outline-dark">
                                <a href="<c:url value="/blog"/>" class="btn btn-outline-secondary">목록</a>
                            </form>
                            <hr>
                            <!-- Comment List -->
                            <a id="comment"></a>
                            <c:forEach var="comment" items="${comments}">
                                <div class="d-flex">
                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://picsum.photos/seed/${comment.id}/50/50" alt="..." /></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">
                                            ${comment.author}
                                            <div class="badge bg-light text-dark text-start">
                                                <c:if test="${empty comment.update_at}">
                                                    created at ${ comment.create_at.year }/${ comment.create_at.monthValue }/${ comment.create_at.dayOfMonth } ${comment.create_at.hour}:${comment.create_at.minute}
                                                </c:if>
                                                <c:if test="${not empty comment.update_at}">
                                                    modified at ${ comment.update_at.year }/${ comment.update_at.monthValue }/${ comment.update_at.dayOfMonth } ${comment.update_at.hour}:${comment.update_at.minute}
                                                </c:if>
                                            </div>
                                            <!-- 본인의 답글인 경우 수정 / 삭제 -->
                                            <c:if test="${not empty userid and userid eq comment.author}">
                                                <button type="button" class="btn btn-outline-dark text-start"
                                                        style="padding: 0 4px; font-size: 10px" onclick="location.href='/blog/comment_update?&id=${comment.id}'">수정</button>
                                                <button type="button" class="btn btn-outline-danger text-start"
                                                        style="padding: 0 4px; font-size: 10px" onclick="location.href='/blog/comment_delete?id=${comment.id}'">삭제</button>
                                            </c:if>
                                        </div>
                                        ${comment.content}<br>
                                    </div>
                                </div><br>
                            </c:forEach>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="col-md-4 col-lg-3">
            <!-- Search Widget -->
            <%@ include file="category_widget.jsp" %>
        </div>
    </div>
</div>

<script type="text/javascript">
    function checkBoard() {
        if (f.content.disabled===true) {
            alert('로그인 후 이용해 주세요.');
            location.href='/common/sign_in';
            return false;
        }
        else if (f.content.value===""){
            alert("답글 내용을 입력해 주세요.")
            f.content.focus()
            return false;
        }
        return true;
    }

    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>
<%@ include file="../bottom.jsp" %>