package com.example.proj.controller;

import com.example.proj.dto.CartypeDTO;
import com.example.proj.service.CartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CartypeController {

    @Autowired
    CartypeService cartypeService;

    @RequestMapping("/type_list")
    public String cartype_list(HttpServletRequest req) {
        List<CartypeDTO> list = cartypeService.listCartype();
        req.setAttribute("listCartype", list);
        return "car/type_list";
    }

    @RequestMapping(value = "/type_write", method = RequestMethod.GET)
    public String cartype_write() {
        return "car/type_write";
    }

    @RequestMapping(value = "/type_write", method = RequestMethod.POST)
    public String cartype_write_pro(HttpServletRequest req, CartypeDTO dto) {
        int res = cartypeService.insertCartype(dto);
        if (res > 0) {
            req.setAttribute("msg", "차종 등록 성공! 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "/car/type_list");
        } else {
            req.setAttribute("msg", "차종 등록 실패... 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "/car/type_detail");
        }
        return "message";
    }

    @RequestMapping("/type_delete")
    public String cartype_delete(HttpServletRequest req, String id) {
        int res = cartypeService.deleteCartype(id);
        if (res > 0)
            req.setAttribute("msg", "차종 삭제 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 삭제 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/car/type_list");
        return "message";
    }

    @RequestMapping("/type_detail")
    public String cartype_detail(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeService.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "car/type_detail";
    }

    @RequestMapping(value = "/type_update", method = RequestMethod.GET)
    public String cartype_update(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeService.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "car/type_update";
    }

    @RequestMapping(value = "/car/type_update", method = RequestMethod.POST)
    public String cartype_update(HttpServletRequest req, CartypeDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setId(0);
        int res = cartypeService.updateCartype(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 수정 성공! 차종 상세 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 수정 실패... 차종 상세 페이지로 이동합니다.");
        req.setAttribute("url", "/car/type_detail?id=" + dto.getId());
        return "message";
    }

}
