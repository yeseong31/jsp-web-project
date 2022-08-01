<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- member_update.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <form name="f" action="member_update.do" method="post" onsubmit="return check()">
        <input name="no" value="${dto.no}" hidden>
        <table border="1" width="80%">
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" value="${dto.name}" readonly></td>
            </tr>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" value="${dto.id}" readonly></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="passwd" value="${dto.passwd}"></td>
            </tr>
            <tr>
                <th>주민등록번호</th>
                <td>
                    <input type="text" name="ssn1" value="${dto.ssn1}" readonly>-
                    <input type="password" name="ssn2" value="${dto.ssn2}" readonly>
                </td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>
                    <input type="text" name="hp1" size="3" maxlength="3" value="${dto.hp1}">-
                    <input type="text" name="hp2" size="4" maxlength="4" value="${dto.hp2}">-
                    <input type="text" name="hp3" size="4" maxlength="4" value="${dto.hp3}">
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="email" value="${dto.email}"></td>
            </tr>
            <tr>
                <td align="center">
                    <input type="submit" value="수정">
                    <input type="reset" value="다시 입력">
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function check() {
        if (f.password.value === "") {
           alert("비밀번호를 입력해 주세요!")
           f.passwd.focus()
           return false
        }
    }
</script>
<%@ include file="bottom.jsp" %>
