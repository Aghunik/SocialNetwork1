package servlet;

import manager.MessageManager;
import manager.UserManager;
import model.Message;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/myMessage")
public class MyMessageServlet extends HttpServlet {
    private MessageManager messageManager = new MessageManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)  req.getSession().getAttribute("user");
        List<Message> messageByFriendId = messageManager.getMessageByFriendId(user.getId());
        req.setAttribute("messages",messageByFriendId);
        req.getRequestDispatcher("/WEB-INF/message/myMessage.jsp").forward(req,resp);


    }
}
