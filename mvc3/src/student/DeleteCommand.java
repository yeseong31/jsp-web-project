package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		StudentDAO dao = new StudentDAO();
		String id = req.getParameter("id");
		try {
			int res = dao.deleteStudent(id);
			if (res > 0) {
				req.setAttribute("msg", "학생 삭제 성공! 학생 목록 페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=list");
			} else {
				req.setAttribute("msg", "학생 삭제 실패! 학생 관리 페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=student");
			}
		} catch (Exception ignored) {}
		return "message.jsp";
	}

}
