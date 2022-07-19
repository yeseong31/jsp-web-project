package myshop.controller;

import myshop.dao.CategoryDAO;
import myshop.dao.CategoryDAOImpl;
import myshop.dto.CategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CateInputOkCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("code");
        String cname = req.getParameter("cname");

        CategoryDAO dao = new CategoryDAOImpl();
        CategoryDTO dto = new CategoryDTO();
        dto.setCode(code);
        dto.setCname(cname);

        int res = dao.insertCate(dto);
        if (res > 0) {
            req.setAttribute("msg", "카테고리 등록 성공!! 카테고리 목록 페이지로 이동합니다.");
            req.setAttribute("url", "cate_list.mall");
        } else {
            req.setAttribute("msg", "카테고리 등록 실패!! 카테고리 목록 페이지로 이동합니다.");
            req.setAttribute("url", "cate_input.mall");
        }
        return "message.jsp";
    }
}
