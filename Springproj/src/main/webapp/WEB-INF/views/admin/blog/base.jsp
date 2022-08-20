<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_list.jsp -->
<%@ include file="../../top.jsp" %>
<section class="py-5">
    <h5 class="display-6 fw-bolder text-center">게시판 관리 페이지</h5>
    <div class="container px-4 px-lg-5 my-5">
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/blog/post_list'">게시물 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/blog/comment_list'">답글 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='#'" disabled>공지사항 관리</button>
    </div>
</section>
<%@ include file="../../bottom.jsp" %>
