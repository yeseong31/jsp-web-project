package com.example.controller;

import com.example.dto.CarDTO;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CarService carService;

    @RequestMapping("/admin/")
    public String admin_home() {
        return "admin/home";
    }

    @RequestMapping("/")
    public String home(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "car/list";
    }

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model) {
        model.addAttribute("msg", "Access Denied");
    }

}
