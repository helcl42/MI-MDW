<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Customer" %>
<%@page import="model.RoleEnum" %>
<%@page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User u = (User) request.getSession().getAttribute("user");
    if (u != null) {
        if (u.getRole() == RoleEnum.ADMIN)
            out.write(u.getName() + " " + u.getSurname() + " (" + u.getUsername() + ")");
        else {
            Customer c = (Customer) u;
            out.write(c.getName() + " " + c.getSurname() + " (" + c.getUsername() + ") | Kredit: " + c.getCredit() + " Kč");
        }

%>
| <a href="/logout">Odhlásit se</a>
<%
} else {
%>
<a href="/login">Přihlášení</a> | <a href="/registration">Registrace</a>
<%
    }
%>
