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
        String num = req.getParameter("num");
        String passwd = req.getParameter("passwd");
        BoardDAO dao = new BoardDAOImpl();

        int res =  dao.deleteBoard(Integer.parseInt(num), passwd);
        if (res > 0) {
            req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        } else if (res < 0) {
            req.setAttribute("msg", "잘못된 비밀번호입니다. 게시글 상세 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + num);
        } else {
            req.setAttribute("msg", "게시글 삭제 실패!! 게시글 상세 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + num);
        }
        return "message.jsp";
    }
}
