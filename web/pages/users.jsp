<%@ page import="ru.qupol.DAO.UserDAO" %>
<%@ page import="ru.qupol.model.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavl
  Date: 22.04.14
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.getUsers();
    session.setAttribute("backPage",request.getRequestURL().toString());
%>
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="style/userStyle.css">
    <title>Users</title>
  </head>
  <body>
  <table>
      <tr>
          <th>id</th>
          <th>name</th>
          <th>pass</th>
          <th>rights</th>
      </tr>
      <%

          for( User user: users){
      %>
      <tr>
          <td><%=user.getId() %></td>
          <td><%=user.getName() %></td>
          <td><%=user.getPassword() %></td>
          <td><%=user.getRights().getRightName()%></td>
      </tr>
       <%
       }
		%>
  </table>
  <a href="logout.jsp"> <input type="button"  value="Log Out" /></a>
  </body>
</html>
