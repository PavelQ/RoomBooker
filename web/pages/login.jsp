<%@ page import="ru.qupol.DAO.UserDAO" %>
<%@ page import="ru.qupol.model.User" %>
<%@ page import="ru.qupol.Validators.Validator" %>
<%@ page import="ru.qupol.Validators.UserValidator" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 05.05.2014
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("backPage",request.getRequestURL().toString());
    UserDAO userDAO = new UserDAO();
    String loginS=null;
    String pass=null;
    //get previous session
    User user=(User)session.getAttribute("user");
    //load login pass
    if (user==null) {
        loginS = request.getParameter("login");
        pass = request.getParameter("password");
    }
    //verify it
    if(user==null && loginS!=null && !loginS.isEmpty())
    {
        Validator validator= new UserValidator(loginS,pass);
        user=(User)validator.validate();

        session.setAttribute("user",user);
    }

%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/userStyle.css">
    <title>Login Page</title>

</head>
<body>
<form action="login.jsp" method="post">
    <table class="center">
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        <td><a href="logout.jsp"> <input type="button"  value="Log Out" /></a> <td/>
        </tr>

    </table>
</form>
<% if(user!=null) {
    out.println(user);
    out.println("<br /><a href='users.jsp'>users</a>");
}
else
{
    out.println("not found");
}
%>

</body>
</html>