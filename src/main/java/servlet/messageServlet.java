package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/message")
public class messageServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)  req.getSession().getAttribute("user");
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);

        req.setAttribute("friend",userManager.getUserById(id));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/message/message.jsp").forward(req,resp);


    }
}
