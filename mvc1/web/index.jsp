<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- index.jsp -->
<html>
<head>
  <title>과목 선택</title>
</head>
<body>
<h1 align="center">과 목 선 택 페 이 지</h1>
<form name="f" action="depart.do" method="post">
  <label>
    과목선택:
    <select name="depart" size="1">
      <option value="c">C</option>
      <option value="java">Java</option>
      <option value="python">Python</option>
      <option value="go">Go</option>
    </select>
  </label>
  <input type="submit" value="전송">
</form>
</body>
</html>