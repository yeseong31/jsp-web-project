package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdDeleteCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pnum = req.getParameter("pnum");
        ProductDAO dao = new ProductDAOImpl();
        int res = dao.deleteProd(Integer.parseInt(pnum));
        if (res > 0)
            req.setAttribute("msg", "상품 삭제 성공!! 상품 목록 페이지로 이동합니다.");
        else
            req.setAttribute("msg", "상품 삭제 실패!! 상품 목록 페이지로 이동합니다.");
        req.setAttribute("url", "prod_list.mall");
        return "message.jsp";
    }
}
