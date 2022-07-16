package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements CommandIf {
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) {
        return "student.jsp";
    }
}
