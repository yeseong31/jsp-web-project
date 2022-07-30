<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- main.jsp -->
<%@ include file="top.jsp" %>
<%@ include file="left.jsp" %>
<div style="float: right; width: 700px">
    <div style="background-color: yellow">
        <h3 style="margin-top: 0; padding-top: 10px">Welcome to My Mall</h3>
    </div>
    <div style="background-color: #eaefe8">
        <c:if test="${empty HIT}">
            <b>HIT 상품이 없습니다</b><br>
        </c:if>
        <c:if test="${not empty HIT}">
            <hr color="green" width="80%">
            <font color="red" size="3">HIT</font>
            <hr color="green" width="80%">
            <br>
        </c:if>
        <table width="100%" border="0" align="center">
            <tr>
                <c:set var="count" value="0"/>
                <c:forEach var="dto" items="${HIT}">
                    <c:set var="count" value="${count+1}"/>
                    <td align="center">
                        <a href="prodView.mall?pnum=${dto.pnum}&select=HIT">
                            <img src="prodImage/${dto.pimage}" width="80" height="60" border="0">
                        </a>
                        <br>${dto.pname}<br>
                        <span style="color: red; ">${dto.price}</span>원<br>
                        <span style="color: blue; ">[${dto.point}]</span>point
                    </td>
                    <c:if test="${count%3==0}">
                        </tr><tr>
                    </c:if>
                </c:forEach>
            </tr>
        </table>
    </div>
</div>
<%@ include file="bottom.jsp" %>

