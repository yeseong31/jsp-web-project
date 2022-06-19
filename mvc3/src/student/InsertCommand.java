package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDTO dto = new StudentDTO();
		dto.setId(req.getParameter("id"));
		dto.setName(req.getParameter("name"));
		dto.setCname(req.getParameter("cname"));
		
		StudentDAO dao = new StudentDAO();
		int res = dao.insertStudent(dto);
		if (res > 0) {
			req.setAttribute("msg", "학생 등록 성공! 학생 목록 페이지로 이동합니다.");
			req.setAttribute("url", "student.do?command=list");
		} else {
			req.setAttribute("msg", "학생 등록 실패! 학생 관리 페이지로 이동합니다.");
			req.setAttribute("url", "student.do?command=student");
		}

		return "message.jsp";
	}

}
