package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import student.dao.StudentDAO;
import student.dto.StudentDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentAnController {

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/student.do")
    public String student() {
        return "/student/student";
    }  // 리턴타입: String, ModelAndView, Model, View 객체, void

    @RequestMapping("/list.do")
    public String listStudent(HttpServletRequest req) {
        List<StudentDTO> list = studentDAO.listStudent();
        req.setAttribute("listStudent", list);
        return "student/list";
    }

    @RequestMapping("/insert.do")
    public String insertStudent(HttpServletRequest req, @ModelAttribute StudentDTO dto) {
        int res = studentDAO.insertStudent(dto);
        if (res > 0) {
            req.setAttribute("msg", "학생 등록 성공! 학생 목록 페이지로 이동합니다.");
            req.setAttribute("url", "list.do");
        } else {
            req.setAttribute("msg", "학생 등록 실패... Index 페이지로 이동합니다.");
            req.setAttribute("url", "student.do");
        }
        return "student/message";
    }

    @RequestMapping("/delete.do")
    public String studentDelete(HttpServletRequest req, @RequestParam String id) {
         int res = studentDAO.deleteStudent(id);
        if (res > 0) {
            req.setAttribute("msg", "학생 삭제 성공! 학생 목록 페이지로 이동합니다.");
            req.setAttribute("url", "list.do");
        } else {
            req.setAttribute("msg", "학생 삭제 실패... Index 페이지로 이동합니다.");
            req.setAttribute("url", "student.do");
        }
        return "student/message";
    }

    @RequestMapping("/find.do")
    public String studentFind(HttpServletRequest req, @RequestParam String name) {
         List<StudentDTO> list = studentDAO.findStudent(name);
        req.setAttribute("listStudent", list);
        return "student/list";
    }

}
