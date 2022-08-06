<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_list.jsp -->
<%@ include file="../top.jsp" %>

<div class="container">
    <h1 class="display-6 text-center">차종 상세 조회</h1>
    <div class="row mt-4">
        <table class="table">
            <thead></thead>
            <tbody>
            <tr>
                <th scope="col" class="text-center">이름</th>
                <th>${getCartype.name}</th>
            </tr>
            <tr>
                <th scope="col" class="text-center">코드</th>
                <th>${getCartype.code}</th>
            </tr>
            <tr>
                <th scope="col" class="text-center">설명</th>
                <th>${getCartype.description}</th>
            </tr>
            </tbody>
        </table>
    </div>
    <button type="button" class="btn btn-outline-dark" onclick="location.href='/car/type_list'">목록</button>
    <button type="button" class="btn btn-outline-secondary"
            onclick="location.href='/car/type_update?id=${getCartype.id}'">수정</button>
    <button type="button" name="delete_btn" class="btn btn-outline-danger"
            onclick="location.href='/car/type_delete?id=${getCartype.id}'">삭제</button>
</div>
<%@ include file="../bottom.jsp" %>
