<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 05.05.2014
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String backPage=(String)session.getAttribute("backPage");
    session.invalidate();
    if(backPage!=null && !backPage.isEmpty()) {
        response.sendRedirect(backPage);
    }
    else
    response.sendRedirect("login.jsp");
%>
