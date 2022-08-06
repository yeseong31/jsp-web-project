package com.example.proj.controller;

import com.example.proj.dto.CartypeDTO;
import com.example.proj.mapper.CartypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartypeController {

    @Autowired
    private CartypeMapper cartypeMapper;

    @RequestMapping("/cartype_list.do")
    public String cartype_list(HttpServletRequest req) {
        List<CartypeDTO> list = cartypeMapper.listCartype();
        req.setAttribute("listCartype", list);
        return "cartype/list";
    }

    @RequestMapping(value = "/cartype_write.do", method = RequestMethod.GET)
    public String cartype_write() {
        return "cartype/write";
    }

    @RequestMapping(value = "/cartype_write.do", method = RequestMethod.POST)
    public String cartype_write_pro(HttpServletRequest req, CartypeDTO dto) {
        int res = cartypeMapper.insertCartype(dto);
        if (res > 0) {
            req.setAttribute("msg", "차종 등록 성공! 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "cartype_list.do");
        } else {
            req.setAttribute("msg", "차종 등록 실패... 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "cartype_detail.do");
        }
        return "message";
    }

    @RequestMapping("/cartype_delete.do")
    public String cartype_delete(HttpServletRequest req, String id) {
        int res = cartypeMapper.deleteCartype(id);
        if (res > 0)
            req.setAttribute("msg", "차종 삭제 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 삭제 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "cartype_list.do");
        return "message";
    }

    @RequestMapping("/cartype_detail.do")
    public String cartype_detail(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeMapper.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "cartype/detail";
    }

    @RequestMapping(value = "/cartype_update.do", method = RequestMethod.GET)
    public String cartype_update(HttpServletRequest req, String id) {
        CartypeDTO dto = cartypeMapper.getCartype(id);
        req.setAttribute("getCartype", dto);
        return "cartype/update";
    }

    @RequestMapping(value = "/cartype_update.do", method = RequestMethod.POST)
    public String cartype_update(HttpServletRequest req, CartypeDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setId(0);
        int res = cartypeMapper.updateCartype(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 수정 성공! 차종 상세 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 수정 실패... 차종 상세 페이지로 이동합니다.");
        req.setAttribute("url", "cartype_detail.do?id=" + dto.getId());
        return "message";
    }

}
