
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<form action="/user/addMessage?id=${friend.id}" method="post">
<textarea name="message" ></textarea><br><br>
    <input type="submit" value="send message">
</form>
</body>
</html>
