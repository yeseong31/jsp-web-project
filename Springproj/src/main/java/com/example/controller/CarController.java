package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CarImageDTO;
import com.example.dto.CarRentDTO;
import com.example.dto.CarTypeDTO;
import com.example.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @RequestMapping("/detail")
    public String car_detail(HttpServletRequest req, int id) {
        CarDTO car = carService.getCar(id);
        CarTypeDTO type = carTypeService.getCarType(String.valueOf(car.getCar_type()));
        List<CarImageDTO> img_list = carImageService.getImageList(id);
        req.setAttribute("getCar", car);
        req.setAttribute("getCarType", type);
        req.setAttribute("getCarImageList", img_list);
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
            CarDTO dto = carService.getCar(Integer.parseInt(id));
            req.setAttribute("getCar", dto);
        }
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "car/rent";
    }

    @PostMapping("/rent")
    public String car_rent(HttpServletRequest req, CarRentDTO dto) {
        // 0. 렌트를 진행하는 사용자 (제대로 된 로그인 기능을 구현하지 않아 임시로 문자열 삽입)
        dto.setUserid("testid");
        // 1. 해당 사용자에 대해 렌트 중인 자동차가 존재하는지 확인

        // 있다면 해당 차량에 대한 '예약 확인' 페이지로 이동

        // 2. 해당 차량이 이미 '렌트' 완료된 차량이라면 예약을 진행하지 않음

        // 3. 대여일이 반납일보다 늦은 경우 (잘못된 날짜 입력) ... 페이지에서 유효 검사?


        int res = carRentService.insert(dto);
        if (res > 0) {
            req.setAttribute("msg", "차량 예약 성공! 예약 확인 페이지로 이동합니다.");
            req.setAttribute("member", "testid");
//            req.setAttribute("rent", carRentService.getRentByUserid("testid"));
//            req.setAttribute("car", carService.getCar(dto.getCar_id()));
            req.setAttribute("url", "/car/rent/comp");
        }
        else {
            req.setAttribute("msg", "차량 예약 실패... 차량 예약 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/type_list");
        }
        return "message";
    }

    @GetMapping("/rent/comp")
    public String car_rent_complete() {
        return "car/rent_complete";
    }

}
