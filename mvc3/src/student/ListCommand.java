package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> list = dao.listStudent();
		req.setAttribute("listStudent", list);
		return "list.jsp";
	}

}
