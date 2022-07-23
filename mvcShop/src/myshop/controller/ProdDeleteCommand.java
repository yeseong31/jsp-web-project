package myshop.controller;

import myshop.dao.ProductDAO;
import myshop.dao.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ProdDeleteCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAOImpl();
        int pnum = Integer.parseInt(req.getParameter("pnum"));
        String imgName = dao.getProd(pnum).getPimage();
        int res = dao.deleteProd(pnum);
        if (res > 0) {
            String deleteImgName = req.getServletContext().getRealPath("WEB-INF/prodImage") + imgName;
            File deleteImg = new File (deleteImgName);
            if (deleteImg.exists() && deleteImg.isFile()) {
                if (deleteImg.delete())
                    req.setAttribute("msg", "상품 삭제 성공!! 상품 목록 페이지로 이동합니다.");
                else
                    req.setAttribute("msg", "상품 삭제 성공(이미지 X)!! 상품 목록 페이지로 이동합니다.");
            }
        } else
            req.setAttribute("msg", "상품 삭제 실패!! 상품 목록 페이지로 이동합니다.");
        req.setAttribute("url", "prod_list.mall");
        return "message.jsp";
    }
}
