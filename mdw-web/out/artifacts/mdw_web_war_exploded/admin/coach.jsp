<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.Destination"%>
<%@page import="model.Route"%>
<%@page import="model.Coach"%>
<%@page import="model.DAO"%>
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
    <title>Rezervační systém - spoje</title>
</head>
<body>
<%
    DAO dao = DAO.getInstance();
%>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - dobiti kreditu</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <h2>Nový autobus</h2>
            <form action="coach" method="post">
                <%
                    String route = (String) request.getAttribute("route");
                %>
                Trasa:<br />
                <select name="route" multiple="false">
                    <c:forEach var="r" items="${requestScope['routes']}">
                        <%
                            Route r2 = (Route) pageContext.getAttribute("r");
                            Destination from2 = dao.getEntity(r2.getFrom());
                            Destination to2 = dao.getEntity(r2.getTo());

                            String selected = "";
                            if (route != null && !route.isEmpty() && Long.parseLong(route) == r2.getId()) {
                                selected = "selected=\"selected\"";
                            }
                        %>
                        <option value="${r.id}" <%=selected%>>
                            <%
                                out.write(from2.getName() + " (" + from2.getCountry() + ") - " + to2.getName() + " (" + to2.getCountry() + ")");
                            %>
                        </option>
                    </c:forEach>
                </select><br />
                Datum a čas odjezdu (ve tvaru hh:mm dd.mm.rrrr):<br />
                <input type="text" value="${requestScope['departure']}" name="departure" /><br />
                Datum a čas příjezdu (ve tvaru hh:mm dd.mm.rrrr):<br />
                <input type="text" value="${requestScope['arrival']}" name="arrival" /><br />
                Kapacita:<br />
                <input type="text" name="capacity" value="${requestScope['capacity']}" /><br />
                <input type="submit" value="OK" />
            </form>
            <h2>Výpis spojů</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Trasa</th>
                    <th>Odjezd</th>
                    <th>Příjezd</th>
                    <th>Kapacita</th>
                </tr>
                </thead>
                <c:forEach var="c" items="${requestScope['coaches']}" varStatus="i">
                    <%
                        Coach c = (Coach) pageContext.getAttribute("c");
                        Route r = dao.getEntity(c.getRoute());
                        Destination from = dao.getEntity(r.getFrom());
                        Destination to = dao.getEntity(r.getTo());
                    %>
                    <tr>
                        <td>${i.count}.</td>
                        <td>${c.id}</td>
                        <td>
                            <%
                                out.write(from.getName() + " (" + from.getCountry() + ") - " + to.getName() + " (" + to.getCountry() + ")");
                            %>
                        </td>
                        <td>
                            <fmt:formatDate value="${c.departureTime}" pattern="HH:mm dd.MM.yyyy"  /><br />
                        </td>
                        <td>
                            <fmt:formatDate value="${c.arrivalTime}" pattern="HH:mm dd.MM.yyyy" />
                        </td>
                        <td>${c.capacity}</td>
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
