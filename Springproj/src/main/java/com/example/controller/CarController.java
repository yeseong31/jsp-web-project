package com.example.controller;

import com.example.dto.*;
import com.example.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/car")
@Log4j2
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    CarTypeService carTypeService;
    @Autowired
    CarImageService carImageService;
    @Autowired
    CarRentService carRentService;
    @Autowired
    MemberService memberService;
    @Autowired
    CarNumService carNumService;

    @RequestMapping("/detail")
    public String car_detail(HttpServletRequest req, int id) {
        CarDTO car = carService.getCar(id);
        CarTypeDTO type = carTypeService.getCarType(String.valueOf(car.getType()));
        List<CarImageDTO> img_list = carImageService.getImageList(id);
        List<CarNumDTO> nums = carNumService.getList(id);
        req.setAttribute("getCar", car);
        req.setAttribute("getCarType", type);
        req.setAttribute("getCarImageList", img_list);
        req.setAttribute("getCarNumList", nums);
        return "car/detail";
    }

    @RequestMapping("/type_list")
    public String car_type_list(HttpServletRequest req) {
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCarTypeList", list);
        return "car/type_list";
    }

    @RequestMapping("/type_detail")
    public String car_type_detail(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        List<CarDTO> list = carService.getCarListByCarType(dto.getId());
        req.setAttribute("getCarType", dto);
        req.setAttribute("getCarList", list);
        return "car/type_detail";
    }

    @GetMapping("/rent")
    public String car_rent(HttpServletRequest req, @RequestParam(required = false) String id) {
        if (id != null) {
            CarNumDTO num = carNumService.getOne(Integer.parseInt(id));
            CarDTO dto = carService.getCar(num.getCar());
            req.setAttribute("getCar", dto);
            req.setAttribute("getCarNum", num);
        }
        return "car/rent";
    }

    @PostMapping("/rent")
    public String car_rent(HttpServletRequest req, CarRentDTO dto) {
        // 렌트를 진행하는 사용자 (세션에 저장된 userid 확인)
        HttpSession session = req.getSession();
        if (session.getAttribute("userid") == null) {
            req.setAttribute("msg", "로그인 후 이용해 주세요.");
            req.setAttribute("url", "/common/sign_in");
            return "message";
        }
        String userid = (String) session.getAttribute("userid");
        dto.setUserid(userid);
        CarNumDTO target = carNumService.getOne(dto.getCar_num_id());
        // 해당 차량에 대해 렌트가 불가능하다면
        if (target == null) {
            req.setAttribute("msg", "등록되지 않은 차량입니다.");
            req.setAttribute("url", "/car/rent");
            return "message";
        }
        if (!target.getIs_available()) {
            req.setAttribute("msg", "다른 사용자에 의해 렌트가 진행된 차량입니다.");
            req.setAttribute("url", "/car/rent");
            return "message";
        }
        CarDTO car = carService.getCar(target.getCar());
        // 이미 렌트가 진행 중인 차량이 있다면
        if (carRentService.getRentByUserid(userid) != null) {
            req.setAttribute("msg", "이미 렌트 중인 차량이 있습니다.");
            req.setAttribute("url", "/car/rent/check");
            return "message";
        }
        target.setNum(car.getName() + " - " + target.getNum());
        if (carRentService.insert(dto) > 0) {
            req.setAttribute("msg", "차량 예약 성공! 예약 확인 페이지로 이동합니다.");
            req.setAttribute("url", "/car/rent/comp");
            session.setAttribute("rent", carRentService.getRentByUserid(userid));
            session.setAttribute("car_num", target);
        } else {
            req.setAttribute("msg", "차량 예약 실패... 차량 예약 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/type_list");
        }
        return "message";
    }

    @GetMapping("/rent/check")
    public String car_rent_check(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("userid") == null) {
            req.setAttribute("msg", "로그인 후 이용해 주세요.");
            req.setAttribute("url", "/common/sign_in");
            return "message";
        }
        String userid = (String) session.getAttribute("userid");
        CarRentDTO dto = carRentService.getRentByUserid(userid);
        CarNumDTO target = carNumService.getOne(dto.getCar_num_id());
        CarDTO car = carService.getCar(target.getCar());
        target.setNum(car.getName() + " - " + target.getNum());
        req.setAttribute("rent", carRentService.getRentByUserid(userid));
        req.setAttribute("car_num", target);
        return "car/rent_complete";
    }

    @GetMapping("/rent/comp")
    public String car_rent_complete() {
        return "car/rent_complete";
    }

}
