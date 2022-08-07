package com.example.proj.controller;

import com.example.proj.dto.CarDTO;
import com.example.proj.dto.CartypeDTO;
import com.example.proj.service.CarService;
import com.example.proj.service.CartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CartypeService cartypeService;
    @Autowired
    CarService carService;

    @RequestMapping("/")
    public String admin_home() {
        return "admin/home";
    }

    @RequestMapping("/car/type_list")
    public String admin_cartype(HttpServletRequest req) {
        List<CartypeDTO> list = cartypeService.getCartypeList();
        req.setAttribute("getCartypeList", list);
        return "admin/car/type_list";
    }

    @RequestMapping(value = "/car/type_write", method = RequestMethod.GET)
    public String admin_cartype_write() {
        return "admin/car/type_write";
    }

    @RequestMapping(value = "/car/type_write", method = RequestMethod.POST)
    public String admin_cartype_write_pro(HttpServletRequest req, CartypeDTO dto) {
        int res = cartypeService.insertCartype(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 등록 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 등록 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/type_list");
        return "message";
    }

    @RequestMapping(value = "/car/type_update", method = RequestMethod.GET)
    public String admin_cartype_update(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeService.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "admin/car/type_update";
    }

    @RequestMapping(value = "/car/type_update", method = RequestMethod.POST)
    public String admin_cartype_update(HttpServletRequest req, CartypeDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setId(0);
        int res = cartypeService.updateCartype(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 수정 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 수정 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/car/type_detail?id=" + dto.getId());
        return "message";
    }

    @RequestMapping("/car/type_delete")
    public String admin_cartype_delete(HttpServletRequest req, String id) {
        int res = cartypeService.deleteCartype(id);
        if (res > 0) {
            req.setAttribute("msg", "차종 삭제 성공! 차종 상세 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/type_list");
        } else {
            req.setAttribute("msg", "차종 삭제 실패... 차종 상세 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/type_list");
        }
        return "message";
    }

    @RequestMapping("/car/list")
    public String admin_car(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "admin/car/car_list";
    }

    @RequestMapping(value = "/car/write", method = RequestMethod.GET)
    public String admin_car_write() {
        return "admin/car/car_write";
    }

    @RequestMapping(value = "/car/write", method = RequestMethod.POST)
    public String admin_car_write_pro(HttpServletRequest req, CarDTO dto) {
        int res = carService.insertCar(dto);
        if (res > 0)
            req.setAttribute("msg", "차량 등록 성공! 차량 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차량 등록 실패... 차량 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/list");
        return "message";
    }

    @RequestMapping(value = "/car/update", method = RequestMethod.GET)
    public String admin_car_update(HttpServletRequest req, String id) {
        CarDTO dto = carService.getCar(id);
        req.setAttribute("getCar", dto);
        return "admin/car/car_update";
    }

    @RequestMapping(value = "/car/update", method = RequestMethod.POST)
    public String admin_car_update_pro(HttpServletRequest req, CarDTO dto) {
        int res = carService.updateCar(dto);
        if (res > 0)
            req.setAttribute("msg", "차량 수정 성공! 차량 상세 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차량 수정 실패... 차량 상세 페이지로 이동합니다.");
        req.setAttribute("url", "/car/detail?id=" + dto.getId());
        return "message";
    }

    @RequestMapping("/car/delete")
    public String admin_car_delete(HttpServletRequest req, String id) {
        int res = carService.deleteCar(id);
        if (res > 0) {
            req.setAttribute("msg", "차량 삭제 성공! 차량 목록 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/list");
        } else {
            req.setAttribute("msg", "차량 삭제 실패... 차량 목록 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/list");
        }
        return "message";
    }

}
