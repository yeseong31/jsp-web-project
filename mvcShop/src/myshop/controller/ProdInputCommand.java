package myshop.controller;

import myshop.dao.CategoryDAO;
import myshop.dao.CategoryDAOImpl;
import myshop.dto.CategoryDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProdInputCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO cateDAO = new CategoryDAOImpl();
        List<CategoryDTO> list = cateDAO.listCate();
        if (list == null || list.size() == 0) return "WEB-INF/admin/cate_input.jsp";
        req.setAttribute("listCate", list);
        return "WEB-INF/admin/prod_input.jsp";
    }
}
