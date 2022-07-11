<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- content.jsp -->
<html>
<head>
    <title>글내용 보기</title>
</head>
<body>
    <div align="center">
        <b>글내용 보기</b>
        <table border="1" width="600px">
            <tr>
                <th bgcolor="yellow" width="20%">글번호</th>
                <td align="center">${getBoard.num}</td>
                <th bgcolor="yellow" width="20%">조회수</th>
                <td align="center">${getBoard.readCount}</td>
            </tr>
            <tr>
                <th bgcolor="yellow" width="20%">작성자</th>
                <td align="center">${getBoard.writer}</td>
                <th bgcolor="yellow" width="20%">작성일</th>
                <td align="center">${getBoard.reg_date}</td>
            </tr>
            <tr>
                <th bgcolor="yellow" width="20%">글제목</th>
                <td colspan="3">${getBoard.subject}</td>
            </tr>
            <tr>
                <th bgcolor="yellow" width="20%">글내용</th>
                <td colspan="3">${getBoard.content}</td>
            </tr>
            <tr>
                <td bgcolor="yellow" colspan="4" align="right">
                    <input type="button" value="글수정"
                           onclick="window.location='board_updateForm.do?num=${getBoard.num}'">
                    <input type="button" value="글삭제"
                           onclick="window.location='board_deleteForm.do?num=${getBoard.num}'">
                    <input type="button" value="글목록" onclick="window.location='board_list.do'">
                </td>
            </tr>
        </table>
    </div>
</body>
</html>