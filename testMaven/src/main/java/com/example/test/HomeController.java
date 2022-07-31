package com.example.test;


import com.example.test.dto.StudentDTO;
import com.example.test.model.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/student.do")
    public String student_index() {
        return "student/student";
    }

    @RequestMapping("/list.do")
    public String student_list(HttpServletRequest req) {
        List<StudentDTO> list = studentMapper.listStudent();
        req.setAttribute("listStudent", list);
        return "student/list";
    }

    @RequestMapping("/insert.do")
    public String student_insert(HttpServletRequest req, @ModelAttribute StudentDTO dto) {
        int res = studentMapper.insertStudent(dto);
        if (res > 0) {
            req.setAttribute("msg", "학생 등록 성공! 학생 목록 페이지로 이동합니다.");
            req.setAttribute("url", "list.do");
        } else {
            req.setAttribute("msg", "학생 등록 실패... Index 페이지로 이동합니다.");
            req.setAttribute("url", "student.do");
        }
        return "message";
    }

    @RequestMapping("/delete.do")
    public String student_delete(HttpServletRequest req, @RequestParam String id) {
        int res = studentMapper.deleteStudent(id);
        if (res > 0) {
            req.setAttribute("msg", "학생 삭제 성공! 학생 목록 페이지로 이동합니다.");
            req.setAttribute("url", "list.do");
        } else {
            req.setAttribute("msg", "학생 삭제 실패... Index 페이지로 이동합니다.");
            req.setAttribute("url", "index.do");
        }
        return "message";
    }

    @RequestMapping("/find.do")
    public String student_find(HttpServletRequest req, @RequestParam String name) {
        List<StudentDTO> list = studentMapper.findStudent(name);
        req.setAttribute("listStudent", list);
        return "student/list";
    }

}