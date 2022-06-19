package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		String id = req.getParameter("id");
		// 아이디로 조회
		try {
			int res = dao.deleteStudent(id);
			if (res > 0) {
				req.setAttribute("msg", "학생 삭제 성공! 학생 목록 페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=list");
			} else {
				req.setAttribute("msg", "학생 삭제 실패! 학생 관리 페이지로 이동합니다.");
				req.setAttribute("url", "student.do?command=student");
			}
		} catch (Exception e) {}
		return "message.jsp";
	}

}
