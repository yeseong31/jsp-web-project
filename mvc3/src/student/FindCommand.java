package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		StudentDAO dao = new StudentDAO();
		String name = req.getParameter("name");
		try {
			List<StudentDTO> list = dao.findStudent(name);
			req.setAttribute("find", list);
		} catch (Exception ignored) {}
		
		return "find.jsp";
	}

}
