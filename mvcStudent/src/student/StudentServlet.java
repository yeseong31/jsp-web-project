package student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String cmd = req.getParameter("command");
        if (cmd == null) cmd = "index";

        String msg, url;
        switch (cmd) {
            case "insert" -> {
                StudentDTO dto = new StudentDTO();
                dto.setId(req.getParameter("id"));
                dto.setName(req.getParameter("name"));
                dto.setCname(req.getParameter("cname"));

                StudentDAO dao = new StudentDAO();
                int res = dao.insertStudent(dto);
                if (res > 0) {
                    msg = "학생 등록 성공!! 학생 목록 페이지로 이동합니다.";
                    url = "student.do?command=list";
                } else {
                    msg = "학생 등록 실패!! 학생 관리 페이지로 이동합니다.";
                    url = "student.do?command=index";
                }
                req.setAttribute("msg", msg);
                req.setAttribute("url", url);
                RequestDispatcher view = req.getRequestDispatcher("message.jsp");
                view.forward(req, resp);
            }
            case "delete" -> {
                String id = req.getParameter("id");
                StudentDAO dao = new StudentDAO();
                int res = dao.deleteStudent(id);
                if (res > 0) {
                    msg = "학생 삭제 성공!! 학생 목록 페이지로 이동합니다.";
                    url = "student.do?command=list";
                } else {
                    msg = "학생 삭제 실패!! 학생 관리 페이지로 이동합니다.";
                    url = "student.do?command=student";
                }
                req.setAttribute("msg", msg);
                req.setAttribute("url", url);
                RequestDispatcher view = req.getRequestDispatcher("message.jsp");
                view.forward(req, resp);
            }
            case "find" -> {
                String name = req.getParameter("name");
                StudentDAO dao = new StudentDAO();
                List<StudentDTO> list = dao.findStudent(name);
                req.setAttribute("listStudent", list);
                RequestDispatcher view = req.getRequestDispatcher("list.jsp");
                view.forward(req, resp);
            }
            case "list" -> {
                StudentDAO dao = new StudentDAO();
                List<StudentDTO> list = dao.listStudent();
                req.setAttribute("listStudent", list);
                RequestDispatcher view = req.getRequestDispatcher("list.jsp");
                view.forward(req, resp);
            }
            case "index" -> {
                RequestDispatcher view = req.getRequestDispatcher("student.jsp");
                view.forward(req, resp);
            }
        }
    }
}
