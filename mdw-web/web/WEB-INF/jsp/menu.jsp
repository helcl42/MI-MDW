<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.RoleEnum"%>
<%@page import="model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="mainmenu">
    <ul id="yw0">
        <li class="active"><a href="/index.jsp">Úvod</a></li>
        <li><a href="/search">Vyhledat spoje</a></li>
        <%
            User u = (User) request.getSession().getAttribute("user");
            if (u != null) {
                if (u.getRole() == RoleEnum.ADMIN) {
        %>
        <li><a href="/admin/users">Uživatelé</a></li>
        <li><a href="/admin/coach">Spoje</a></li>
        <li><a href="/admin/route">Trasy</a></li>
        <li><a href="/admin/destination">Destinace</a></li>
        <li><a href="/admin/hotelsystem">Hotel</a></li>
        <%
        } else if (u.getRole() == RoleEnum.CUSTOMER) {
        %>
        <li><a href="/customer/reservations">Můj Profil</a></li>
        <%                    }
        }
        %>
    </ul>
</div>

