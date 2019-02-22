<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyMessage</title>
</head>
<body>

<table border="1">
    <tr>
        <td>From</td>
        <td>Message</td>
        <td>DateTime</td>
    </tr>
    <c:forEach var="message" items="${messages}">
    <tr>
        <td>${message.user.name} &nbsp; ${message.user.surname}  <br>
            <img src="/getImage?picName=${message.user.picUrl}" width="50"/>
        </td>
        <td>${message.message}</td>
        <td>${message.date}</td>
    </tr>

    </c:forEach>
</table>
<a href="/user/friendMessage">sent Message</a>


</body>
</html>
