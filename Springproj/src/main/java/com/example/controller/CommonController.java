package com.example.controller;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    MemberService memberService;

    @GetMapping("/sign_in")
    public String sign_in() {
        return "common/sign_in";
    }

    @PostMapping("/sign_in")
    public String sign_in(HttpServletRequest req, MemberDTO dto) {
        // 존재하지 않는 사용자인 경우
        if (memberService.checkMemberId(dto.getUserid()) <= 0) {
            req.setAttribute("msg", "존재하지 않는 사용자입니다.");
            req.setAttribute("url", "/common/sign_in");
            return "message";
        }
        // 비밀번호 확인 (추후 로직 변경 예정)
        if (!memberService.getMemberPassword(dto.getUserid()).equals(dto.getPassword())) {
            req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
            req.setAttribute("url", "/common/sign_in");
            return "message";
        }
        // 로그인 진행 (추후 로직 변경 예정)
        req.setAttribute("url", "/");
        req.setAttribute("msg", "로그인 성공");
        return "message";
    }

    @GetMapping("/sign_up")
    public String sign_up() {
        return "common/sign_up";
    }

    @PostMapping("/sign_up")
    public String sign_up(HttpServletRequest req, MemberDTO dto) {
        // 아이디 중복 확인
        if (memberService.checkMemberId(dto.getUserid()) > 0) {
            req.setAttribute("msg", "이미 존재하는 아이디입니다.");
            req.setAttribute("url", "/common/sign_up");
            return "message";
        }
        // 이메일 중복 확인
        if (memberService.checkMemberEmail(dto.getEmail()) > 0) {
            req.setAttribute("msg", "이미 존재하는 이메일입니다.");
            req.setAttribute("url", "/common/sign_up");
            return "message";
        }
        // 회원가입 진행
        int res = memberService.insertMember(dto);
        if (res > 0) {
            req.setAttribute("msg", "회원가입 성공! 로그인 페이지로 이동합니다.");
            req.setAttribute("url", "/common/sign_in");
        } else {
            req.setAttribute("msg", "회원가입 실패... 회원가입 페이지로 이동합니다.");
            req.setAttribute("url", "/common/sign_up");
        }
        return "message";
    }

    @GetMapping("/logout")
    public void logout() {}

}
