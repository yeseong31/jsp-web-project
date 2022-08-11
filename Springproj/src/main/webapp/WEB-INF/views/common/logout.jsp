<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sign_in.jsp -->
<%@ include file="../top.jsp" %>
<div style="font-size: 14px; text-align: center; width: 100%; min-height: 80vh; display: flex; flex-direction: row;
            align-items: center;justify-content: center;background-color: #fafafa;">
    <form name="f" action="<c:url value="/common/logout"/>" method="post">
        <button type="submit" class="btn btn-primary signup-button" style="width: 258px; margin-left: 2px"> 로그아웃 </button>
        <label><input name="${_csrf.parameterName}" value="${_csrf.token}" hidden/></label>
    </form>
</div>
<%@ include file="../bottom.jsp" %>