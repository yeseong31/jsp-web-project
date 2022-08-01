package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String num = req.getParameter("num");
        BoardDAO dao = new BoardDAOImpl();

        BoardDTO dto = dao.getBoard(Integer.parseInt(num), "update");
        req.setAttribute("dto", dto);
        return "WEB-INF/board/updateForm.jsp";
    }
}
