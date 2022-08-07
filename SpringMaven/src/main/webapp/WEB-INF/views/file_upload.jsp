<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- file_upload.jsp -->
<html>
<head>
    <title>파일 업로드 테스트</title>
</head>
<body>
    <form name="f" action="file_upload.do" method="post" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <th>이름</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>파일명</th>
                <td><input type="file" name="filename"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="전송"></td>
            </tr>
        </table>
    </form>
</body>
</html>


