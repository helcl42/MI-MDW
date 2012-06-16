<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Customer"%>
<%@page import="model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Destination"%>
<%@page import="model.Route"%>
<%@page import="model.Coach"%>
<%@page import="model.Reservation"%>
<%@page import="model.DAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="language" content="en" />

    <link rel="stylesheet" type="text/css" href="/resources/css/screen.css" media="screen, projection" />
    <link rel="stylesheet" type="text/css" href="/resources/css/print.css" media="print" />
    <!--[if lt IE 8]>
    <link rel="stylesheet" type="text/css" href="/resources/css/ie.css" media="screen, projection" />
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/form.css" />

    <title>Rezervační systém - profil</title>
</head>
<body>
<%
    DAO dao = DAO.getInstance();
    SimpleDateFormat stf = new SimpleDateFormat();
%>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - profil</div>
    </div>

    <jsp:include page="/WEB-INF/jsp/menu.jsp" />

    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />

            <% Customer cust = (Customer) request.getAttribute("usr");%>

            <h2>Informace o uživateli:</h2>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><% out.write(cust.getUsername());%></td>
                </tr>
                <tr>
                    <td>Jméno:</td>
                    <td><% out.write(cust.getSurname());%></td>
                </tr>
                <tr>
                    <td>Příjmení:</td>
                    <td><% out.write(cust.getName());%></td>
                </tr>
                <tr>
                    <td>Číslo účtu:</td>
                    <td><% out.write(cust.getAccount().toString());%></td>
                </tr>
                <tr>
                    <td>Kredit:</td>
                    <td><% out.write(cust.getCredit().toString());%></td>
                </tr>
            </table>

            <a href="/protected/edituser?id=<% out.write(cust.getId().toString());%>">Edit</a><br />
            <a href="/customer/topupcredit">Top Up Credit</a>

            <h2>Vytvořené rezervace</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Cesta</th>
                    <th>Datum odjezdu</th>
                    <th>Čas odjezdu</th>
                    <th>Datum příjezdu</th>
                    <th>Čas příjezdu</th>
                    <th>Cena</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <c:forEach var="res" items="${requestScope['reservations']}">
                    <tr>
                        <%
                            Reservation res = (Reservation) pageContext.getAttribute("res");
                            Coach c = dao.getEntity(res.getCoach());
                            Route r = dao.getEntity(c.getRoute());
                            Destination from = dao.getEntity(r.getFrom());
                            Destination to = dao.getEntity(r.getTo());
                        %>
                        <td>${res.id}</td>
                        <td>
                            <%
                                out.write(from.getName() + " - " + to.getName());
                            %>
                        </td>
                        <td>
                            <%
                                stf.applyPattern("dd.MM.yyyy");
                                out.write(stf.format(c.getDepartureTime()));
                            %>
                        </td>
                        <td>
                            <%
                                stf.applyPattern("HH:mm");
                                out.write(stf.format(c.getDepartureTime()));
                            %>
                        </td>
                        <td>
                            <%
                                stf.applyPattern("dd.MM.yyyy");
                                out.write(stf.format(c.getArrivalTime()));
                            %>
                        </td>
                        <td>
                            <%
                                stf.applyPattern("HH:mm");
                                out.write(stf.format(c.getArrivalTime()));
                            %>
                        </td>
                        <td>${res.price} Kč</td>
                        <td><a href="/customer/deletereservation?resId=${res.id}">Vymazat</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
