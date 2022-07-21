package myshop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdInputCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "WEB-INF/admin/prod_input.jsp";
    }
}
