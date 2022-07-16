package depart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartServlet", value = "/DepartServlet")
public class DepartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        arg0.setCharacterEncoding("UTF-8");
        arg1.setContentType("text/html; charset=UTF-8");

        String depart = arg0.getParameter("depart");

        DepartExpert de = new DepartExpert();
        List<String> list = de.advice(depart);

        // request를 JSP로 전달
        arg0.setAttribute("advice", list);
        RequestDispatcher view = arg0.getRequestDispatcher("result.jsp");
        view.forward(arg0, arg1);
    }

}
