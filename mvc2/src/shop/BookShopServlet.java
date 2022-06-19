package shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "BookShopServlet", value = "/BookShopServlet")
public class BookShopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // request가 가지고 있는 세션 이용
        HttpSession session = req.getSession();
        List<BookDTO> list = (List)session.getAttribute("cart");

        // 커맨드 패턴
        String cmd = req.getParameter("command");
        if (cmd.equals("CHK")) {
            // 결과를 저장하는 해시 테이블 생성
            Hashtable<String, BookDTO> table = makeHashtable(list);
            req.setAttribute("result", table);
            // 페이지 이동
            RequestDispatcher view = req.getRequestDispatcher("bookShopResult.jsp");
            view.forward(req, resp);
        } else if (cmd.equals("ADD")) {
            if (list == null) list = new ArrayList<>();
            BookDTO dto = getBook(req);
            list.add(dto);
        } else if (cmd.equals("DEL")) {
            String idx = req.getParameter("idx");
            list.remove(Integer.parseInt(idx));
        }

        session.setAttribute("cart", list);
        RequestDispatcher view = req.getRequestDispatcher("bookShop.jsp");
        view.forward(req, resp);

    }

    protected BookDTO getBook(HttpServletRequest req) {
        String data = req.getParameter("book");
        String qty = req.getParameter("qty");

        Scanner sc = new Scanner(data).useDelimiter("/");
        BookDTO dto = new BookDTO();

        dto.setTitle(sc.next());
        dto.setAuthor(sc.next());
        dto.setPrice(sc.nextInt());
        dto.setQty(Integer.parseInt(qty));

        return dto;

    }

    private Hashtable<String, BookDTO> makeHashtable(List<BookDTO> list) {

        Hashtable<String, BookDTO> table = new Hashtable<>();

        for (BookDTO dto : list) {
            String title = dto.getTitle();
            int qty = dto.getQty();

            // 테이블에 이미 존재하는 책인 경우
            if (table.containsKey(title)) {
                // 도서명으로 테이블 조회... 새롭게 테이블에 저장
                BookDTO target = table.get(title);
                target.setQty(target.getQty() + qty);
            }
            // 테이블에 존재하지 않는 책인 경우
            else {
                table.put(title, dto);
            }
        }

        return table;

    }

}
