<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- left.jsp -->
<div style="float: left; width: 297px; height: 100%; border-right: 1px black solid">
    <table style="width: 90%; border: black 1px solid">
        <caption>Tree/view</caption>
        <c:if test="${empty listCate}">
            <td>
                등록된 카테고리가 없습니다.
            </td>
        </c:if>
        <c:forEach var="dto" items="${listCate}">
            <tr>
                <td style="text-align: left; padding-left: 8px">
<%--                    <form name="f" method="post">--%>
<%--                        <label><input type="text" name="cname" value="${dto.cname}" hidden></label>--%>
<%--                        <label><input type="text" name="code" value="${dto.code}" hidden></label>--%>
<%--                    </form>--%>
                    <a href="cgProdList.mall?cname=${dto.cname}&code=${dto.code}">${dto.cname} (${dto.code})</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript">
    function cgList(mode, name) {

    }
</script>