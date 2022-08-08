package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CartypeDTO;
import com.example.service.CarService;
import com.example.service.CartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    CartypeService cartypeService;

    @RequestMapping("/")
    public String home(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "car/list";
    }

    @RequestMapping("/car/detail")
    public String car_detail(HttpServletRequest req, String id) {
        CarDTO dto = carService.getCar(id);
        req.setAttribute("getCar", dto);
        return "car/detail";
    }

    @RequestMapping("/car/type_list")
    public String cartype_list(HttpServletRequest req) {
        List<CartypeDTO> list = cartypeService.getCartypeList();
        req.setAttribute("getCartypeList", list);
        return "car/type_list";
    }

    @RequestMapping("/car/type_detail")
    public String cartype_detail(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeService.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "car/type_detail";
    }

    @RequestMapping("/car/reserve")
    public String car_reserve(HttpServletRequest req, @RequestParam(required = false) String id) {
        CarDTO dto = null;
        if (id != null)
            dto = carService.getCar(id);
        req.setAttribute("getCar", dto);
        return "car/reserve";
    }

}
