package com.example.controller;

import com.example.dto.CarRentDTO;
import com.example.service.CarRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/car/rent")
public class AdminCarRentController {
    @Autowired
    CarRentService carRentService;

    @GetMapping("/list")
    public String list(HttpServletRequest req) {
        List<CarRentDTO> list = carRentService.getList();
        req.setAttribute("list", list);
        return "admin/rent/list";
    }
}
