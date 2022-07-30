package myshop.controller;

import myshop.dao.CategoryDAO;
import myshop.dao.CategoryDAOImpl;
import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;
import myshop.dto.CategoryDTO;
import myshop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MallCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO cadao = new CategoryDAOImpl();
        List<CategoryDTO> list = cadao.listCate();
        if (list == null || list.size()==0) {
            req.setAttribute("msg", "쇼핑몰 준비중 입니다.");
            req.setAttribute("url", "index.mall");
            return "message.jsp";
        }
        HttpSession session = req.getSession();
        session.setAttribute("listCate", list);
        ProductDAO pdao = new ProductDAOImpl();
        List<ProductDTO> list1 = pdao.selectBySpec("HIT");
        List<ProductDTO> list2 = pdao.selectBySpec("NEW");
        List<ProductDTO> list3 = pdao.selectBySpec("BEST");
        session.setAttribute("HIT", list1);
        session.setAttribute("NEW", list2);
        session.setAttribute("BEST", list3);
        return "WEB-INF/mall/main.jsp";
    }
}
