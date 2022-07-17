package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        BoardDTO dto = new BoardDTO();
        dto.setWriter(req.getParameter("writer"));
        dto.setEmail(req.getParameter("email"));
        dto.setSubject(req.getParameter("subject"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setContent(req.getParameter("content"));
        dto.setIp(req.getRemoteAddr());

        BoardDAO dao = new BoardDAOImpl();
        int res = dao.insertBoard(dto);

        if (res > 0)
            req.setAttribute("msg", "게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "게시글 등록 실패!! 게시글 목록 페이지로 이동합니다.");
        req.setAttribute("url", "board_list.do");
        return "message.jsp";
    }
}
