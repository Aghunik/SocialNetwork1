package servlet;

import manager.MessageManager;
import model.Message;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/friendMessage")
public class FriendMessageServlet extends HttpServlet {
    private MessageManager messageManager = new MessageManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)  req.getSession().getAttribute("user");
        List<Message> messageByUserId = messageManager.getMessageByUserId(user.getId());
        req.setAttribute("messages",messageByUserId);
        req.getRequestDispatcher("/WEB-INF/message/messageByFriend.jsp").forward(req,resp);
    }
}
