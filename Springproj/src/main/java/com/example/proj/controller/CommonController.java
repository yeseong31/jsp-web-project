package com.example.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "common/signin";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "common/signup";
    }

}
