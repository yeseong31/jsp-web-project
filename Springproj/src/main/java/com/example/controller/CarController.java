package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CarTypeDTO;
import com.example.service.CarService;
import com.example.service.CarTypeService;
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
    CarTypeService carTypeService;

    @RequestMapping("/")
    public String home(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "car/list";
    }

    @RequestMapping("/car/detail")
    public String car_detail(HttpServletRequest req, String id) {
        CarDTO car = carService.getCar(id);
        CarTypeDTO type = carTypeService.getCarType(String.valueOf(car.getCar_type()));
        req.setAttribute("getCar", car);
        req.setAttribute("getCarType", type);
        return "car/detail";
    }

    @RequestMapping("/car/type_list")
    public String car_type_list(HttpServletRequest req) {
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCarTypeList", list);
        return "car/type_list";
    }

    @RequestMapping("/car/type_detail")
    public String car_type_detail(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        req.setAttribute("getCarType", dto);
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
