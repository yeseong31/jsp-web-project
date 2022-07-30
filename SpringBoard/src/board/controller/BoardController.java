package board.controller;

import board.dto.BoardDTO;
import board.mybatis.BoardMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
	
	@RequestMapping("/board_list.do")
	public String BoardList(HttpServletRequest req) {
		List<BoardDTO> list = BoardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "board/list";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String BoardWriteForm() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String BoardWritePro(HttpServletRequest req, @ModelAttribute BoardDTO dto) {
		dto.setIp(req.getRemoteAddr());
		int res = BoardMapper.insertBoard(dto);
		if (res > 0) {
			req.setAttribute("msg", "게시글 등록 성공! 게시글 목록 페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		} else {
			req.setAttribute("msg", "게시글 등록 실패... Index 페이지로 이동합니다.");
			req.setAttribute("url", "board_writeForm.do");
		}
		return "message";
	}
	
	@RequestMapping("/board_content.do")
	public ModelAndView BoardContent(@RequestParam int num) {
		BoardDTO dto = BoardMapper.getBoard(num, "content");
		return new ModelAndView("board/content", "getBoard", dto);
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView BoardUpdateForm(@RequestParam int num) {
		BoardDTO dto = BoardMapper.getBoard(num, "update");
		return new ModelAndView("board/updateForm", "getBoard", dto);
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public String BoardUpdatePro(HttpServletRequest req, @ModelAttribute BoardDTO dto, BindingResult result) {
		if (result.hasErrors()) {
			// 에러 발생 시 대처 방법을 서술하면 됨
			dto.setNum(0);
		}
		
		 int res = BoardMapper.updateBoard(dto);
		if (res > 0) {
			req.setAttribute("msg", "게시글 수정 성공! 게시글 목록 페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		} else if (res < 0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!");
			req.setAttribute("url", "board_updateForm.do?num=" + dto.getNum());
		} else {
			req.setAttribute("msg", "게시글 수정 실패... 게시글 확인 페이지로 이동합니다.");
			req.setAttribute("url", "board_content.do?num=" + dto.getNum());
		}
		return "message";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public String BoardDeleteForm(HttpServletRequest req, @RequestParam int num) {
		req.setAttribute("param", num);
		return "board/deleteForm";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public String BoardDeletePro(HttpServletRequest req, @RequestParam Map<String, String> params) {
		// Map 타입으로 param 값을 받으면 parameter 명이 key가 되고, parameter 값이 value가 된다.
		 int num = Integer.parseInt(params.get("num"));
		 String passwd = params.get("passwd");
		 int res = BoardMapper.deleteBoard(num, passwd);

		if (res > 0) {
			req.setAttribute("msg", "게시글 삭제 성공! 게시글 목록 페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		} else if (res < 0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!");
			req.setAttribute("url", "board_deleteForm.do?num=" + num);
		} else {
			req.setAttribute("msg", "게시글 삭제 실패... 게시글 확인 페이지로 이동합니다.");
			req.setAttribute("url", "board_content.do?num=" + num);
		}
		return "message";
	}

}
