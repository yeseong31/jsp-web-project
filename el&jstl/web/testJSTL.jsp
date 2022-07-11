<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- testJSTL.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>testJSTL</title>
</head>
<body>
    <!-- 값 설정 -->
    <c:set var="a" value="10"/>
    a값 설정 후 출력: <c:out value="${a}"/><br>

    <!-- switch -->
    <c:choose>
        <c:when test="${a == 9}"><h2>a의 값은 9입니다.</h2></c:when>
        <c:when test="${a == 10}"><h2>a의 값은 10입니다.</h2></c:when>
        <c:when test="${a == 11}"><h2>a의 값은 11입니다.</h2></c:when>
        <c:when test="${a == 12}"><h2>a의 값은 12입니다.</h2></c:when>
        <c:otherwise><h2>a의 값을 모르겠습니다...</h2></c:otherwise>
    </c:choose>

    <%--
    <!-- 조건문 -->
    <c:if test="${a == 10}">
        <h2>a의 값은 10입니다.</h2>
    </c:if>
    <!-- else 문은 없음 -->
    <c:if test="${a != 10}">
        <h2>a의 값은 10이 아닙니다.</h2>
    </c:if>
    --%>

    <!-- 값 삭제 -->
    <c:remove var="a"/>
    a값 삭제 후 출력: <c:out value="${a}"/><br>

    <!-- 일반적인 for 문: 1부터 100까지의 합 구하기 -->
    <c:set var="sum" value="0"/>
    <c:forEach var="i" begin="1" end="100" step="1">
        <c:set var="sum" value="${sum + i}"/>
    </c:forEach>


    <h2>1부터 100까지의 합은? ${sum}</h2>

</body>
</html>