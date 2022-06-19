package board.controller;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            req.setAttribute("msg", "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        }
        // 비밀번호가 틀린 경우
        else if (res < 0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
            req.setAttribute("url", "board_updateForm.do?num=" + dto.getNum());
        } else {
            req.setAttribute("msg", "게시글 수정 실패!! 게시물 내용 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + dto.getNum());
        }

        return "message.jsp";

    }
}
