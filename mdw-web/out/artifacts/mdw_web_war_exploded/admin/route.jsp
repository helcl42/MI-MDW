<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Destination"%>
<%@page import="model.Route"%>
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

    <title>Rezervační systém - trasy</title>
</head>
<body>
<%
    DAO dao = DAO.getInstance();
%>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - trasy</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />

    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />

            <h2>Nová trasa</h2>
            <form action="route" method="post">
                <%
                    String departure = (String) request.getAttribute("departure");
                    String arrival = (String) request.getAttribute("arrival");
                %>
                Odjezdová stanice:<br />
                <select name="departure" multiple="false">
                    <c:forEach var="d" items="${requestScope['destinations']}">
                        <%
                            Destination d1 = (Destination) pageContext.getAttribute("d");
                            String selected1 = "";
                            if (departure != null && !departure.isEmpty() && Long.parseLong(departure) == d1.getId()) {
                                selected1 = "selected=\"selected\"";
                            }
                        %>
                        <option value="${d.id}" <%=selected1%>>${d.name} (${d.country})</option>
                    </c:forEach>
                </select><br />
                Příjezdová stanice:<br />
                <select name="arrival" multiple="false">
                    <c:forEach var="d" items="${requestScope['destinations']}">
                        <%
                            Destination d2 = (Destination) pageContext.getAttribute("d");
                            String selected2 = "";
                            if (arrival != null && !arrival.isEmpty() && Long.parseLong(arrival) == d2.getId()) {
                                selected2 = "selected=\"selected\"";
                            }
                        %>
                        <option value="${d.id}" <%=selected2%>>${d.name} (${d.country})</option>
                    </c:forEach>
                </select><br />
                Cena:<br />
                <input type="text" name="price" value="${requestScope['price']}" /><br />
                Vzdálenost:<br />
                <input type="text" name="distance" value="${requestScope['destination']}" /><br />
                <input type="submit" value="OK" />
            </form>

            <h2>Výpis tras</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Z</th>
                    <th>Do</th>
                    <th>Cena</th>
                    <th>Vzdálenost</th>
                </tr>
                </thead>
                <c:forEach var="r" items="${requestScope['routes']}" varStatus="i">
                    <%
                        Route r = (Route) pageContext.getAttribute("r");
                        Destination from = dao.getEntity(r.getFrom());
                        Destination to = dao.getEntity(r.getTo());
                    %>
                    <tr>
                        <td>${i.count}.</td>
                        <td>${r.id}</td>
                        <td>
                            <%
                                out.write(from.getName() + " (" + from.getCountry() + ")");
                            %>
                        </td>
                        <td>
                            <%
                                out.write(to.getName() + " (" + to.getCountry() + ")");
                            %>
                        </td>
                        <td>${r.routePrice}</td>
                        <td>${r.distance}</td>
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
