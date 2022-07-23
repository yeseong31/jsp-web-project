<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>JSP 파일 업로드</h1>
    <form action="fileUpload_ok.do" method="post" enctype="multipart/form-data">
        <table border="1" width="500">
            <tr>
                <th>이름</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>파일명</th>
                <td><input type="file" name="filename"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="파일 전송">
                    <input type="reset" value="다시 입력">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
