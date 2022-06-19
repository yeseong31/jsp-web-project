package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDAO dao = new BoardDAOImpl();
        int num = Integer.parseInt(req.getParameter("num"));

        BoardDTO dto = dao.getBoard(num, "update");
        req.setAttribute("getBoard", dto);

        return "WEB-INF/board/updateForm.jsp";
    }
}
