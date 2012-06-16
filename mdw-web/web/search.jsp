<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO"%>
<%@page import="model.Destination"%>
<%@page import="model.Route"%>
<%@page import="model.Coach"%>
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

    <title>Rezervační systém - vyhledat spoj</title>
</head>
<body>
<%
    DAO dao = DAO.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
    Date now = new Date(System.currentTimeMillis() + 7200000);
%>

<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - vyhledat spoj</div>
    </div>

    <jsp:include page="/WEB-INF/jsp/menu.jsp" />

    <div class="container">
        <div id="content">
            <div class="form">
                <jsp:include page="/WEB-INF/jsp/messages.jsp" />
                <form action="search" method="post">
                    <table>
                        <tr>
                            <td>Odkud: &nbsp;</td>
                            <td><input type="text" name="from" value="${requestScope["tmpFrom"]}" /></td>
                        </tr>
                        <tr>
                            <td>Kam: &nbsp;</td>
                            <td><input type="text" name="to" value="${requestScope["tmpTo"]}" /></td>
                        </tr>
                        <tr>
                            <td>Čas a datum odjezdu: &nbsp;</td>
                            <td><input type="text" name="departureTime" value="<%
                                                if (request.getAttribute("tmpDepartureTime") == null) {
                                                    out.write(sdf.format(now));
                                                } else {
                                                    out.write(request.getAttribute("tmpDepartureTime").toString());
                                                }
                                               %>" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Vyhledat" /></td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </form>
            </div>
            <!--h2>Výsledky hledání</h2-->

            <%
                if (request.getAttribute("coaches") != null) {
                    out.write("<h2>Výsledky hledání</h2>");
                    List<Coach> l = (List<Coach>) request.getAttribute("coaches");
                    if (l.isEmpty()) {
                        out.write("<strong style=\"color:red\">Nebyly nalezeny žádné spoje.</strong>");
                    }
                }

            %>

            <c:forEach var="c" items="${requestScope['coaches']}" varStatus="i">
                <%
                    Coach c = (Coach) pageContext.getAttribute("c");
                    Route r = dao.getEntity(c.getRoute());
                    Destination from = dao.getEntity(r.getFrom());
                    Destination to = dao.getEntity(r.getTo());
                    sdf.applyPattern("HH:mm (dd.MM.yyyy)");
                %>
                <table style="border-top: solid 1px;border-bottom: solid 1px">
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
                    <tr>
                        <td><a href="/customer/createreservation?coachId=${c.id}">Rezervovat</a></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
