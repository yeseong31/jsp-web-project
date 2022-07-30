package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MallCgProdListCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String code = req.getParameter("code");
        ProductDAO dao = new ProductDAOImpl();
        List<ProductDTO> list = dao.getListProdByCateCode(code);
        req.setAttribute("prodList", list);
        req.setAttribute("cname", cname);
        return "WEB-INF/mall/cgProdList.jsp";
    }
}
