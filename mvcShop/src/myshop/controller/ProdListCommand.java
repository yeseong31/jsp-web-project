package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProdListCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAOImpl();
        List<ProductDTO> dto = dao.listProd();
        req.setAttribute("listProd", dto);
        return "WEB-INF/admin/prod_list.jsp";
    }
}
