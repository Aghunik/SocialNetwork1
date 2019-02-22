<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<table border="1">
    <tr>
        <td>To</td>
        <td>Message</td>
        <td>DateTime</td>
    </tr>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td>${message.friend.name} &nbsp; ${message.friend.surname}  <br>
                <img src="/getImage?picName=${message.friend.picUrl}" width="50"/>
            </td>
            <td>${message.message}</td>
            <td>${message.date}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
