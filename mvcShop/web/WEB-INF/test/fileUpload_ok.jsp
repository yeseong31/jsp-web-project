<%@ page contentType="text/html;charset=UTF-8" import="com.oreilly.servlet.*, java.io.*, java.util.Objects" %>
<%
    // request
    MultipartRequest mr = null;
    // 위치
    String upPath = config.getServletContext().getRealPath("files");
    // 크기(MB)
    int len = 10 * 1024 * 1024;

    try {
        mr = new MultipartRequest(request, upPath, len, "UTF-8");
    } catch (IOException e) {
        e.printStackTrace();
    }

    File file = Objects.requireNonNull(mr).getFile("filename");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
올린이: <%=mr.getParameter("name")%><br>
파일명: <%=mr.getFilesystemName("filename")%>
파일크기:
<%
    int filesize = 0;
    if (mr.getFile("filename") != null) {
        filesize = (int) file.length();
    }
%>
<%=filesize%> Bytes
</body>
</html>
