package myshop.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "myshopServlet", value = "/myshopServlet")
public class myshopServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String uri = req.getRequestURI();
        String path = req.getContextPath();
        String cmd = uri.substring(path.length());

        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);
        String nextPage = (String) cmdIf.processCommand(req, resp);
        RequestDispatcher view = req.getRequestDispatcher(nextPage);
        view.forward(req, resp);
    }
}
