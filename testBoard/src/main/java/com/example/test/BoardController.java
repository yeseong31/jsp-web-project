package com.example.test;

import com.example.test.dto.BoardDTO;
import com.example.test.model.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BoardMapper boardMapper;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/board_list.do")
    public String board_list(HttpServletRequest req) {
        List<BoardDTO> list = boardMapper.listBoard();
        req.setAttribute("listBoard", list);
        return "board/list";
    }

    @RequestMapping(value = "/board_write.do", method = RequestMethod.GET)
    public String board_write() {
        return "board/writeForm";
    }

    @RequestMapping(value = "/board_write.do", method = RequestMethod.POST)
    public String board_write_pro(HttpServletRequest req, @ModelAttribute BoardDTO dto) {
        dto.setIp(req.getRemoteAddr());
        int res = boardMapper.insertBoard(dto);
        if (res > 0) {
            req.setAttribute("msg", "게시글 등록 성공! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        } else {
            req.setAttribute("msg", "게시글 등록 실패... Index 페이지로 이동합니다.");
            req.setAttribute("url", "board_write.do");
        }
        return "message";
    }

    @RequestMapping("/board_content.do")
    public ModelAndView board_content(@RequestParam int num) {
        BoardDTO dto = boardMapper.getBoard(num, "content");
        return new ModelAndView("board/content", "getBoard", dto);
    }

    @RequestMapping(value = "/board_update.do", method = RequestMethod.GET)
    public ModelAndView board_update(@RequestParam int num) {
        BoardDTO dto = boardMapper.getBoard(num, "update");
        return new ModelAndView("board/updateForm", "getBoard", dto);
    }

    @RequestMapping(value = "/board_update.do", method = RequestMethod.POST)
    public String board_update_pro(HttpServletRequest req, @ModelAttribute BoardDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setNum(0);
        int res = boardMapper.updateBoard(dto);
        if (res > 0) {
            req.setAttribute("msg", "게시글 수정 성공! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        } else if (res < 0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!");
            req.setAttribute("url", "board_update.do?num=" + dto.getNum());
        } else {
            req.setAttribute("msg", "게시글 수정 실패... 게시글 확인 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + dto.getNum());
        }
        return "message";
    }

    @RequestMapping(value = "/board_delete.do", method = RequestMethod.GET)
    public String board_delete(HttpServletRequest req, @RequestParam int num) {
        req.setAttribute("param", num);
        return "board/deleteForm";
    }

    @RequestMapping(value = "/board_delete.do", method = RequestMethod.POST)
    public String board_delete_pro(HttpServletRequest req, @RequestParam Map<String, String> params) {
        int num = Integer.parseInt(params.get("num"));
        String passwd = params.get("passwd");
        int res = boardMapper.deleteBoard(num, passwd);
        if (res > 0) {
            req.setAttribute("msg", "게시글 삭제 성공! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        } else if (res < 0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!");
            req.setAttribute("url", "board_delete.do?num=" + num);
        } else {
            req.setAttribute("msg", "게시글 삭제 실패... 게시글 확인 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + num);
        }
        return "message";
    }

}
