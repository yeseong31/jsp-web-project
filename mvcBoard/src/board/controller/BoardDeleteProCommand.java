package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        String passwd = req.getParameter("passwd");

        BoardDAO dao = new BoardDAOImpl();
        int res = dao.deleteBoard(num, passwd);

        if (res > 0) {
            req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        }
        // 비밀번호가 틀린 경우
        else if (res < 0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
            req.setAttribute("url", "board_deleteForm.do?num=" + num);
        } else {
            req.setAttribute("msg", "게시글 삭제 실패!! 게시물 내용 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + num);
        }

        return "message.jsp";
    }
}
