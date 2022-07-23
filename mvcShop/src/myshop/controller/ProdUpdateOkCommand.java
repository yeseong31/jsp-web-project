package myshop.controller;

import com.oreilly.servlet.MultipartRequest;
import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdUpdateOkCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MultipartRequest mr;
        String upPath = req.getServletContext().getRealPath("WEB-INF/prodImage");
        int len = 10 * 1024 * 1024;

        try {
            mr = new MultipartRequest(req, upPath, len, "UTF-8");
            ProductDAO dao = new ProductDAOImpl();
            int res = dao.updateProd(mr);
            if (res > 0) {
                req.setAttribute("msg", "상품 수정 성공!! 상품 목록 페이지로 이동합니다.");
                req.setAttribute("url", "prod_list.mall");
            } else {
                req.setAttribute("msg", "상품 수정 실패!! 상품 목록 페이지로 이동합니다.");
                req.setAttribute("url", "prod_update.mall?pnum=" + mr.getParameter("pnum"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            req.setAttribute("msg", "file upload ERORR!!");
            req.setAttribute("url", "admin.mall");
        }
        return "message.jsp";
    }
}
