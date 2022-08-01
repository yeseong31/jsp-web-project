package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardListCommand implements CommandIf {
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) {
        BoardDAO dao = new BoardDAOImpl();
        List<BoardDTO> list = dao.listBoard();
        req.setAttribute("listBoard", list);
        return "WEB-INF/board/list.jsp";
    }
}
