package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf {
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");

        StudentDAO dao = new StudentDAO();
        int res = dao.deleteStudent(id);
        String msg, url;
        if (res > 0) {
            msg = "학생 삭제 성공!! 학생 목록 페이지로 이동합니다.";
            url = "student.do?command=list";
        } else {
            msg = "학생 삭제 실패!! 학생 관리 페이지로 이동합니다.";
            url = "student.do?command=student";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
