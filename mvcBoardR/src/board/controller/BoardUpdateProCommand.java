package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        BoardDTO dto = new BoardDTO();
        dto.setNum(Integer.parseInt(req.getParameter("num")));
        dto.setWriter(req.getParameter("writer"));
        dto.setEmail(req.getParameter("email"));
        dto.setSubject(req.getParameter("subject"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setContent(req.getParameter("content"));

        BoardDAO dao = new BoardDAOImpl();
        int res = dao.updateBoard(dto);
        if (res > 0) {
            req.setAttribute("msg", "게시글 수정 성공!! 게시글 상세 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + dto.getNum());
        } else if (res < 0) {
            req.setAttribute("msg", "잘못된 비밀번호입니다. 다시 입력해 주세요.");
            req.setAttribute("url", "board_update.do?num=" + dto.getNum());
        } else {
            req.setAttribute("msg", "게시글 수정 실패!! 게시글 상세 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + dto.getNum());
        }
        return "message.jsp";
    }
}
