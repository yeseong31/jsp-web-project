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
        arg0.setCharacterEncoding("EUC-KR");
        arg1.setContentType("text/html; charset=EUC-KR");

        String depart = arg0.getParameter("depart");

        DepartExpert de = new DepartExpert();
        List<String> list = de.advice(depart);

//		PrintWriter pw = arg1.getWriter();
//		for (String msg : list) {
//			pw.println("<h2>" + msg + "</h2>");
//		}
//		pw.close();

        // request를 JSP로 전달
        arg0.setAttribute("advice", list);
        RequestDispatcher view = arg0.getRequestDispatcher("result.jsp");
        view.forward(arg0, arg1);
    }

}
