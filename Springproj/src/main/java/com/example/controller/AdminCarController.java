package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CarTypeDTO;
import com.example.service.CarImageService;
import com.example.service.CarService;
import com.example.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/type_list")
    public String admin_car_type(HttpServletRequest req) {
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCarTypeList", list);
        return "admin/car/type_list";
    }

    @RequestMapping("/type_detail")
    public String admin_car_type_detail(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        req.setAttribute("getCarType", dto);
        return "admin/car/type_detail";
    }

    @RequestMapping(value = "/type_write", method = RequestMethod.GET)
    public String admin_car_type_write() {
        return "admin/car/type_write";
    }

    @RequestMapping(value = "/type_write", method = RequestMethod.POST)
    public String admin_car_type_write_pro(HttpServletRequest req, CarTypeDTO dto) {
        int res = carTypeService.insertCarType(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 등록 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 등록 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/admin/car/type_list");
        return "message";
    }

    @RequestMapping(value = "/type_update", method = RequestMethod.GET)
    public String admin_car_type_update(HttpServletRequest req, String id) {
        CarTypeDTO dto = carTypeService.getCarType(id);
        req.setAttribute("getCarType", dto);
        return "admin/car/type_update";
    }

    @RequestMapping(value = "/type_update", method = RequestMethod.POST)
    public String admin_car_type_update(HttpServletRequest req, CarTypeDTO dto, BindingResult result) {
        if (result.hasErrors()) dto.setId(0);
        int res = carTypeService.updateCarType(dto);
        if (res > 0)
            req.setAttribute("msg", "차종 수정 성공! 차종 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차종 수정 실패... 차종 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/car/type_detail?id=" + dto.getId());
        return "message";
    }

    @RequestMapping("/type_delete")
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

    @RequestMapping("/list")
    public String admin_car(HttpServletRequest req) {
        List<CarDTO> list = carService.getCarList();
        req.setAttribute("getCarList", list);
        return "admin/car/list";
    }

    @RequestMapping("/detail")
    public String admin_car_detail(HttpServletRequest req, String id) {
        CarDTO car = carService.getCar(id);
        CarTypeDTO type = carTypeService.getCarType(String.valueOf(car.getCar_type()));
        req.setAttribute("getCar", car);
        req.setAttribute("getCarType", type);
        return "admin/car/detail";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
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
            int res = 1;
            UUID uuid = UUID.randomUUID();
            String filename = Objects.requireNonNull(file).getOriginalFilename();
            res = carImageService.insertImage(
                    String.valueOf(car_id), String.valueOf(uuid), dateString, filename, String.valueOf(1));
            if (res <= 0) return 0;
            File target = new File(uploadPath, dateString + "/" + uuid + "_" + Objects.requireNonNull(filename));
            try {
                file.transferTo(target);
            } catch (IOException ignored) {}
        }
        return 1;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String admin_car_write_pro(HttpServletRequest req, CarDTO dto) {
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

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String admin_car_update(HttpServletRequest req, String id) {
        CarDTO dto = carService.getCar(id);
        List<CarTypeDTO> list = carTypeService.getCarTypeList();
        req.setAttribute("getCar", dto);
        req.setAttribute("getCarTypeList", list);
        return "admin/car/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String admin_car_update_pro(HttpServletRequest req, CarDTO dto) {
        // 차량 정보 수정
        if (carService.updateCar(dto) <= 0)
            req.setAttribute("msg", "차량 수정 실패... 차량 상세 페이지로 이동합니다.");
        // 차량 이미지 수정
        else if (file_upload(req, dto.getId()) <= 0)
            req.setAttribute("msg", "차량 이미지 수정 실패... 차량 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "차량 수정 성공! 차량 목록 페이지로 이동합니다.");
        req.setAttribute("url", "/car/detail?id=" + dto.getId());
        return "message";
    }

    @RequestMapping("/delete")
    public String admin_car_delete(HttpServletRequest req, String id) {
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
        MultipartFile file = mr.getFile("filename");
        Calendar cal = Calendar.getInstance();
        String dateString = String.format("%04d/%02d/%02d/",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));

        String filename = dateString + Objects.requireNonNull(file).getOriginalFilename();
        File target = new File(uploadPath, Objects.requireNonNull(filename));
        try {
            file.transferTo(target);
        } catch (IOException ignored) {}

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
