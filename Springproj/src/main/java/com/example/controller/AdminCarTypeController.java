package com.example.controller;

import com.example.dto.CarTypeDTO;
import com.example.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/car")
public class AdminCarTypeController {
    @Autowired
    CarTypeService carTypeService;

    @GetMapping("/type_list")
    public String admin_car_type(HttpServletRequest req) {
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCarTypeList", list);
        return "admin/car/type_list";
    }

    @GetMapping("/type_detail")
    public String admin_car_type_detail(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        req.setAttribute("getCarType", dto);
        return "admin/car/type_detail";
    }

    @GetMapping("/type_write")
    public String admin_car_type_write() {
        return "admin/car/type_write";
    }

    @PostMapping("/type_write")
    public String admin_car_type_write(HttpServletRequest req, CarTypeDTO dto) {
        int res = carTypeService.insertCarType(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 등록 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 등록 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/type_list");
        return "message";
    }

    @GetMapping("/type_update")
    public String admin_car_type_update(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        req.setAttribute("getCarType", dto);
        return "admin/car/type_update";
    }

    @PostMapping("/type_update")
    public String admin_car_type_update(HttpServletRequest req, CarTypeDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setId(0);
        int res = carTypeService.updateCarType(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 수정 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 수정 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/type_detail?id=" + dto.getId());
        return "message";
    }

    @GetMapping("/type_delete")
    public String admin_car_type_delete(HttpServletRequest req, String id) {
        int res = carTypeService.deleteCarType(id);
        if (res > 0) {
            req.setAttribute("msg", "차종 삭제 성공! 차종 상세 페이지로 이동합니다.");
        } else {
            req.setAttribute("msg", "차종 삭제 실패... 차종 상세 페이지로 이동합니다.");
        }
        req.setAttribute("url", "/admin/car/type_list");
        return "message";
    }
}
