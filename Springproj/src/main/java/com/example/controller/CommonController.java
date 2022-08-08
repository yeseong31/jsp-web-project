package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    @GetMapping("/common/signIn")
    public void signIn(String error, String logout, Model model) {
        if (error != null)
            model.addAttribute("error", "Sign In Error Check Your Account!");
        if (logout != null)
            model.addAttribute("logout", "Logout!");
    }

    @GetMapping("/common/signUp")
    public String signup() {
        return "common/signUp";
    }

    @GetMapping("/common/logout")
    public void logout() {}

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model) {
        model.addAttribute("msg", "Access Denied");
    }

}
