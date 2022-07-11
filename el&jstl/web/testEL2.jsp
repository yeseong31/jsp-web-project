<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!-- testEL2.jsp -->
<html>
<head>
    <title>표현언어 예제2</title>
</head>
<body>
    <div align="center">
        <h3>표현언어 사용 예제 2: 파라미터 값 처리</h3>
    </div>
    <hr>
    <form method="post">
        이름: <input type="text" name="name">
        <input type="submit" value="확인">
    </form>
    <hr color="red">

    <h3>입력하신 이름은 ${param.name}입니다.</h3>

</body>
</html>








