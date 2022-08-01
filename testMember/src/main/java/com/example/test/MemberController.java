package com.example.test;

import com.example.test.dto.MemberDTO;
import com.example.test.model.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/member_index.do")
    public String member_index() {
        return "member/index";
    }

    @RequestMapping("/member_ssn.do")
    public String member_ssn() {
        return "member/memberSsn";
    }

    @RequestMapping("/member_check.do")
    public String member_check(HttpServletRequest req, @RequestParam Map<String, String> params) {
        boolean isMember = memberMapper.checkMember(params);
        if (isMember) {
            req.setAttribute("msg", "이미 회원이십니다. 로그인을 해 주세요!!");
            req.setAttribute("url", "member_index.do");
            return "message";
        }
        return "member/member_input";
    }

    @RequestMapping("/member_all.do")
    public String member_all(HttpServletRequest req, @RequestParam(required = false) String mode) {
        List<MemberDTO> list = null;
        if (mode == null) {
            mode = "all";
            list = memberMapper.listMember();
        } else {
            String search = req.getParameter("search");
            String searchString = req.getParameter("searchString");
            if (search != null)
                list = memberMapper.findMember(search, searchString);
        }
        req.setAttribute("mode", mode);
        req.setAttribute("listMember", list);
        return "member/memberAll";
    }

    @RequestMapping(value = "/member_update.do", method = RequestMethod.GET)
    public String member_update(HttpServletRequest req, int no) {
        MemberDTO dto = memberMapper.getMember(no);
        req.setAttribute("dto", dto);
        return "member/member_update";
    }

    @RequestMapping(value = "/member_update.do", method = RequestMethod.POST)
    public String member_update_ok(HttpServletRequest req, MemberDTO dto) {
        int res = memberMapper.updateMember(dto);
        if (res > 0) {
            req.setAttribute("msg", "회원수정 성공!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        } else {
            req.setAttribute("msg", "회원수정 실패!! 회원등록페이지로 이동합니다.");
            req.setAttribute("url", "member_update.do?no=" + dto.getNo());
        }
        return "message";
    }

    @RequestMapping(value = "/member_delete.do")
    public String member_delete(HttpServletRequest req, int no) {
        int res = memberMapper.deleteMember(no);
        if (res > 0)
            req.setAttribute("msg", "회원삭제 성공!! 회원목록페이지로 이동합니다.");
        else
            req.setAttribute("msg", "회원삭제 실패!! 회원목록페이지로 이동합니다.");
        req.setAttribute("url", "member_all.do");
        return "message";
    }

    // login


}
