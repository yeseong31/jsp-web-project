package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdUpdateCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pnum = Integer.parseInt(req.getParameter("pnum"));
        ProductDAO dao = new ProductDAOImpl();
        ProductDTO dto = dao.getProd(pnum);
        req.setAttribute("dto", dto);
        return "WEB-INF/admin/prod_update.jsp";
    }
}
