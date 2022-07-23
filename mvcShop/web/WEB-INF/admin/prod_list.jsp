<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prod_list.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <table style="width: 100%; border-top: blue 3px double; border-bottom: blue 3px double">
        <caption>카 테 고 리 목 록</caption>
        <tr style="background-color: #ffcc00">
            <th style="width: 50px">번호</th>
            <th style="width: 120px">상품코드</th>
            <th style="width: 250px">상품명</th>
            <th style="width: 80px">이미지</th>
            <th style="width: 100px">가격</th>
            <th style="width: 80px">제조사</th>
            <th style="width: 50px">수량</th>
            <th>수정|삭제</th>
        </tr>
        <c:if test="${empty listProd}">
            <td colspan="8">
                등록된 상품이 없습니다.
            </td>
        </c:if>
        <c:forEach var="dto" items="${listProd}">
            <tr>
                <td style="text-align: left; padding-left: 8px">${dto.pnum}</td>
                <td style="text-align: center">${dto.pcategory_fk}</td>
                <td style="text-align: center">${dto.pname}</td>
                <td style="text-align: center">${dto.pimage}</td>
                <td style="text-align: right; padding-right: 8px">${dto.price}</td>
                <td style="text-align: center">${dto.pcompany}</td>
                <td style="text-align: right; padding-right: 8px">${dto.pqty}</td>
                <td style="text-align: center">
                    <a href="#">수정</a>
                    <a href="prod_delete.mall?pnum=${dto.pnum}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="bottom.jsp" %>
