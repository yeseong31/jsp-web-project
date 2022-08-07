package com.example.proj.controller;

import com.example.proj.dto.CartypeDTO;
import com.example.proj.service.CartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CartypeController {

    @Autowired
    CartypeService cartypeService;

    @RequestMapping("/type_list")
    public String cartype_list(HttpServletRequest req) {
        List<CartypeDTO> list = cartypeService.getCartypeList();
        req.setAttribute("getCartypeList", list);
        return "car/type_list";
    }

    @RequestMapping("/type_detail")
    public String cartype_detail(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeService.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "car/type_detail";
    }

}
