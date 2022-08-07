package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller
public class HomeController {

    @Resource(name = "uploadPath")
    private String uploadPath;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/file_upload.do", method = RequestMethod.GET)
    public String file_upload() {
        return "file_upload";
    }

    @RequestMapping(value = "/file_upload.do", method = RequestMethod.POST)
    public String file_upload_ok(HttpServletRequest req) {
        // dispatcher-servlet에 beans 등록 필요 (형변환 시에는 오류 X, 실행 시 오류 발생)
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
        MultipartFile file = mr.getFile("filename");

        String filename = Objects.requireNonNull(file).getOriginalFilename();
        File target = new File(uploadPath, Objects.requireNonNull(filename));
        try {
            file.transferTo(target);
        } catch (IOException ignored) {}
        return "index";
    }

}
