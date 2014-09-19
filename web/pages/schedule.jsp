<%@ page import="ru.qupol.DAO.RequestDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.qupol.DAO.RequestDAOLocal" %>

<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 27.04.2014
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/userStyle.css">
    <title>Schedule</title>
</head>
<body>
<table>
    Current month requests
    <tr>
        <th>id</th>
        <th>user</th>
        <th>room</th>
        <th>From Date</th>
        <th>From Time</th>
    </tr>

    <%
        RequestDAOLocal rDAO = new RequestDAO();
        List<ru.qupol.model.Request> requests = rDAO.getThisMonthRequests();
        for( ru.qupol.model.Request curentRequest: requests){
    %>


    <tr>
        <td><%=curentRequest.getId() %></td>
        <td><%=curentRequest.getUser().getName()%></td>
        <td><%=curentRequest.getRoom().getName()%></td>
        <td><%=curentRequest.getFormatedDateFrom("dd.MM.yyyy")%></td>
        <td><%=curentRequest.getFormatedDateFrom("kk:mm")%></td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
