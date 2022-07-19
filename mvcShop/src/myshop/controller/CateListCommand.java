package myshop.controller;

import myshop.dao.CategoryDAO;
import myshop.dao.CategoryDAOImpl;
import myshop.dto.CategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CateListCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        CategoryDAO dao = new CategoryDAOImpl();
        List<CategoryDTO> list = dao.listCate();
        req.setAttribute("listCate", list);
        return "WEB-INF/admin/cate_list.jsp";
    }
}
