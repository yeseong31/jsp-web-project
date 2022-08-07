package com.example.proj.controller;

import com.example.proj.dto.CarDTO;
import com.example.proj.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping("/")
    public String car_list(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "car/car_list";
    }

    @RequestMapping("/car/detail")
    public String car_detail(HttpServletRequest req, String id) {
        CarDTO dto = carService.getCar(id);
        req.setAttribute("getCar", dto);
        return "car/car_detail";
    }

}
