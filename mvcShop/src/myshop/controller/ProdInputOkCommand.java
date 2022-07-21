package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.ProductDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdInputOkCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
        String pname = req.getParameter("name");
        String pcode = req.getParameter("code");
        String pcompany = req.getParameter("company");
        String pimage = req.getParameter("img");
        String pqty = req.getParameter("quantity");
        String price = req.getParameter("price");
        String pcontent = req.getParameter("content");
        String point = req.getParameter("point");

        ProductDAO dao = new ProductDAOImpl();
        ProductDTO dto = new ProductDTO();
        dto.setPname(pname);
        dto.setPcategory_fk(pcode);
        dto.setPcompany(pcompany);
        dto.setPimage(pimage);
        dto.setPqty(Integer.parseInt(pqty));
        dto.setPrice(Integer.parseInt(price));
        dto.setPcontents(pcontent);
        dto.setPoint(Integer.parseInt(point));

        int res = dao.insertProd(dto);
        if (res > 0) {
            req.setAttribute("msg", "상품 등록 성공!! 상품 목록 페이지로 이동합니다.");
            req.setAttribute("url", "prod_list.mall");
        } else {
            req.setAttribute("msg", "상품 등록 실패!! 상품 목록 페이지로 이동합니다.");
            req.setAttribute("url", "prod_input.mall");
        }
        return "message.jsp";
    }
}
