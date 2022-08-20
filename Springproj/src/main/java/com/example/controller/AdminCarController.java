package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CarTypeDTO;
import com.example.service.CarImageService;
import com.example.service.CarService;
import com.example.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/admin/car")
public class AdminCarController {
    @Autowired
    CarTypeService carTypeService;
    @Autowired
    CarService carService;
    @Autowired
    CarImageService carImageService;

    @Resource(name = "uploadPath")
    private String uploadPath;

    @GetMapping("/list")
    public String admin_car(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "admin/car/list";
    }

    @GetMapping("/detail")
    public String admin_car_detail(HttpServletRequest req, int id) {
        CarDTO car = carService.getCar(id);
        CarTypeDTO type = carTypeService.getCarType(String.valueOf(car.getType()));
        req.setAttribute("getCar", car);
        req.setAttribute("getCarType", type);
        return "admin/car/detail";
    }

    @GetMapping("/write")
    public String admin_car_write(HttpServletRequest req) {
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCarTypeList", list);
        return "admin/car/write";
    }

    public int file_upload(HttpServletRequest req, int car_id) {
        // 파일 등록
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
        List<MultipartFile> files = mr.getFiles("filename");

        if (files.size() == 0) return 1;

        // 파일 경로 지정 (연, 월, 일)
        Calendar cal = Calendar.getInstance();
        String dateString = String.format("%04d/%02d/%02d",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        // 파일 저장
        for (MultipartFile file : files) {
            int res;
            UUID uuid = UUID.randomUUID();
            String filename = Objects.requireNonNull(file).getOriginalFilename();
            res = carImageService.insertImage(
                    car_id, String.valueOf(uuid), dateString, filename, String.valueOf(1));
            if (res <= 0) return 0;
            File target = new File(uploadPath, dateString + "/" + uuid + "_" + Objects.requireNonNull(filename));
            try {
                file.transferTo(target);
            } catch (IOException ignored) {}
        }
        return 1;
    }

    @PostMapping("/write")
    public String admin_car_write(HttpServletRequest req, CarDTO dto) {
        // 차량 정보 저장
        if (carService.insertCar(dto) <= 0) {
            req.setAttribute("msg", "차량 등록 실패... 차량 목록 페이지로 이동합니다.");
            req.setAttribute("url", "/admin/car/list");
            return "message";
        }
        // 차량 이미지 등록
        if (file_upload(req, carService.getCarIdByCode(dto.getCode())) < 1)
            req.setAttribute("msg", "차량 이미지 등록 실패... 차량 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차량 등록 성공! 차량 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/list");
        return "message";
    }

    @GetMapping("/update")
    public String admin_car_update(HttpServletRequest req, int id) {
        CarDTO dto = carService.getCar(id);
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCar", dto);
        req.setAttribute("getCarTypeList", list);
        return "admin/car/update";
    }

    @PostMapping("/update")
    public String admin_car_update(HttpServletRequest req, CarDTO dto) {
        // 차량 정보 수정
        if (carService.updateCar(dto) <= 0)
            req.setAttribute("msg", "차량 수정 실패... 차량 상세 페이지로 이동합니다.");
        // 차량 이미지 수정
        else if (file_upload(req, dto.getId()) <= 0)
            req.setAttribute("msg", "차량 이미지 수정 실패... 차량 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차량 수정 성공! 차량 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/detail?id=" + dto.getId());
        return "message";
    }

    @GetMapping("/delete")
    public String admin_car_delete(HttpServletRequest req, int id) {
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
