package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdViewCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAOImpl();
        ProductDTO dto = dao.getProd(Integer.parseInt(req.getParameter("pnum")));
        req.setAttribute("dto", dto);
        req.setAttribute("upPath", req.getServletContext().getRealPath("/WEB-INF/prodImage/"));
        return "WEB-INF/admin/prod_view.jsp";
    }
}
