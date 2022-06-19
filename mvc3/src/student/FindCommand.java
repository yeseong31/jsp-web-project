package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		// 학생명으로 조회...
		String name = req.getParameter("name");

		// DB 내 해당 학생명으로 된 데이터 전부를 조회
		try {
			List<StudentDTO> list = dao.findStudent(name);
			req.setAttribute("find", list);
		} catch (Exception e) {}
		
		return "find.jsp";
	}

}
