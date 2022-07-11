<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- testJSTL2.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>testJSTL2</title>
</head>
<body>

<div align="center">
    <table border="1" style="width: 800px;">
        <tr style="background-color: yellow">
            <c:forEach var="i" begin="2" end="9" step="1">
                <th>${i}</th>
            </c:forEach>
        </tr>

        <c:forEach var="i" begin="1" end="9" step="1">
            <tr>
                <c:forEach var="j" begin="2" end="9" step="1">
                    <th>${j}x${i}=${i * j}</th>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>