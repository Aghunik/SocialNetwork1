package manager;

import dateutil.DateUtil;
import db.DBConnectionProvider;
import model.Message;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class MessageManager {
    private Connection connection;
    private UserManager userManager;

    public MessageManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
        userManager = new UserManager();
    }

    public void addMessage(long user_id, long friend_id, String message) {

        try {
            String query = "INSERT INTO message(user_id, friend_id, message,date)" +
                    "VALUE(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, user_id);
            preparedStatement.setLong(2, friend_id);
            preparedStatement.setString(3, message);
            preparedStatement.setString(4, DateUtil.convertDateToString(new Date()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Message> getMessageByUserId(long userId) {
        String query = "SELECT * FROM message WHERE user_id =" + userId;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Message> messages = new LinkedList<Message>();
            while (resultSet.next()) {
                Message message = new Message();
                message.setUser(userManager.getUserById(resultSet.getInt(1)));
                message.setFriend(userManager.getUserById(resultSet.getInt(2)));
                message.setMessage(resultSet.getString(3));
                message.setDate(DateUtil.convertStringToDate(resultSet.getString(4)));
                messages.add(message);
            }
            return messages;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Message> getMessageByFriendId(long friendId) {
        String query = "SELECT * FROM message WHERE friend_id =" + friendId;
        ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Message> messages = new LinkedList<Message>();
            while (resultSet.next()) {
                Message message = new Message();
                message.setUser(userManager.getUserById(resultSet.getInt(1)));
                message.setFriend(userManager.getUserById(resultSet.getInt(2)));
                message.setMessage(resultSet.getString(3));
                message.setDate(DateUtil.convertStringToDate(resultSet.getString(4)));
                messages.add(message);
            }
            return messages;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
