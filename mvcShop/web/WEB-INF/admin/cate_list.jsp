<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- cate_list.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <table border="1" style="width: 600px">
        <caption>카 테 고 리 목 록</caption>
        <tr style="background-color: yellow">
            <th>번호</th>
            <th>카테고리 코드</th>
            <th>카테고리명</th>
            <th>삭제</th>
        </tr>
        <c:if test="${empty listCate}">
            <td colspan="4">
                등록된 카테고리가 없습니다.
            </td>
        </c:if>
        <c:forEach var="dto" items="${listCate}">
            <tr>
                <td style="text-align: right; padding-right: 8px">${dto.cnum}</td>
                <td style="text-align: center">${dto.code}</td>
                <td style="text-align: center">${dto.cname}</td>
                <td><a href="cate_delete.mall?cnum=${dto.cnum}">삭제</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="bottom.jsp" %>
