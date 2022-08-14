package com.example.controller;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/list")
    public String admin_member_list(HttpServletRequest req) {
        List<MemberDTO> list = memberService.getMemberList();
        req.setAttribute("getMemberList", list);
        return "admin/member/list";
    }

    @GetMapping("/insert")
    public String admin_member_insert() {
        return "admin/member/insert";
    }

    @GetMapping("/detail")
    public String admin_member_detail(HttpServletRequest req, @RequestParam String userid) {
        MemberDTO dto = memberService.getMember(userid);
        req.setAttribute("dto", dto);
        return "admin/member/detail";
    }

}
