package student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String cmd = req.getParameter("command");

        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);
        String nextPage = cmdIf.processCommand(req, resp);
        RequestDispatcher view = req.getRequestDispatcher(nextPage);
        view.forward(req, resp);
    }
}
