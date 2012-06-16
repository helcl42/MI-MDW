<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO"%>
<%@page import="model.Destination"%>
<%@page import="model.Route"%>
<%@page import="model.Coach"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Rezervační systém - Potvrdit rezervaci</title>
</head>
<body>
<%
    DAO dao = DAO.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm (dd.MM.yyyy)");
    Coach c = (Coach) request.getAttribute("reservedCoach");
    Route r = dao.getEntity(c.getRoute());
    Destination from = dao.getEntity(r.getFrom());
    Destination to = dao.getEntity(r.getTo());
%>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - Potvrdit rezervaci</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <h2>Vybraná trasa:</h2>
            <table>
                <tr>
                    <td>Odjezd: </td>
                    <td>
                        <%
                            out.write(from.getName());
                        %>
                    </td>
                    <td>
                        <%
                            out.write(sdf.format(c.getDepartureTime()));
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Příjezd: </td>
                    <td>
                        <%
                            out.write(to.getName());
                        %>
                    </td>
                    <td>
                        <%
                            out.write(sdf.format(c.getArrivalTime()));
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Kapacita: </td>
                    <td>
                        <%
                            out.write(c.getCapacity().toString());
                        %>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Cena: </td>
                    <td>
                        <%
                            out.write(r.getRoutePrice() + " Kč");
                        %>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <div class="form">
                <form action="/customer/createreservation" method="post">
                    <input type="hidden" name="coachId" value="<%out.write(c.getId().toString());%>">
                    <input type="submit" value="Potvrdit">
                </form>
            </div>
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
