package servlet;


import manager.MessageManager;
import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/user/addMessage")
public class AddMessageServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    private MessageManager messageManager = new MessageManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)  req.getSession().getAttribute("user");
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        String message = req.getParameter("message");
        messageManager.addMessage(user.getId(),id,message);
        User userById = userManager.getUserById(id);
        req.setAttribute("friend",userById);
        req.getRequestDispatcher("/WEB-INF/message/message.jsp").forward(req,resp);


    }
}
