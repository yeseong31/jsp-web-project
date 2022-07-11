package student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String cmd = req.getParameter("command");
        String nextPage;

        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);

        nextPage = (String) cmdIf.processCommand(req, resp);
        RequestDispatcher view = req.getRequestDispatcher(nextPage);
        view.forward(req, resp);

    }

}
