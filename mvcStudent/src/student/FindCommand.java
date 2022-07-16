package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCommand implements CommandIf {
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");

        StudentDAO dao = new StudentDAO();
        List<StudentDTO> list = dao.findStudent(name);
        req.setAttribute("listStudent", list);
        return "list.jsp";
    }
}
