<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Access Denied</title>
</head>
<body>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <h1 class="display-4 fw-bolder">Access Denied</h1>
        <h2 class="display-5 fw-bolder"><c:out value="${SPRING_SECURITY_403_EXEPTION.getMessage()}"/></h2>
        <h3 class="display-5 fw-bolder"><c:out value="${msg}"/></h3>
    </div>
</section>

</body>
</html>