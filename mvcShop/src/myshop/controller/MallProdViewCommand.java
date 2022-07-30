package myshop.controller;

import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MallProdViewCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pnum = Integer.parseInt(req.getParameter("pnum"));
        String select = req.getParameter("select");
        HttpSession session = req.getSession();
        List<ProductDTO> list = (List) session.getAttribute(select);
        for (ProductDTO dto : list) {
            if (dto.getPnum() == pnum) {
                req.setAttribute("dto", dto);
            }
        }
        return "WEB-INF/mall/prod_view.jsp";
    }
}
