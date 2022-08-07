<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- home.jsp -->
<%@ include file="../top.jsp" %>
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='#'" disabled>사용자 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/car/type_list'">차종 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/car/list'">차량 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='#'" disabled>예약 관리</button>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='#'" disabled>게시판 관리</button>
    </div>
</section>
<%@ include file="../bottom.jsp" %>
