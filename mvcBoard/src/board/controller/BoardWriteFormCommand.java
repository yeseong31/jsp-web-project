package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

public class BoardWriteFormCommand implements CommandIf {
	

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		return "WEB-INF/board/writeForm.jsp";
	}
	
	
}
