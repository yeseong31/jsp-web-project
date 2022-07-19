package myshop.controller;

import myshop.dao.CategoryDAO;
import myshop.dao.CategoryDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CateDeleteCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String cnum = req.getParameter("cnum");
        CategoryDAO dao = new CategoryDAOImpl();
        int res = dao.deleteCate(Integer.parseInt(cnum));
        if (res > 0)
            req.setAttribute("msg", "카테고리 삭제 성공!! 카테고리 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "카테고리 삭제 실패!! 카테고리 목록 페이지로 이동합니다.");
        req.setAttribute("url", "cate_list.mall");
        return "message.jsp";
    }
}
