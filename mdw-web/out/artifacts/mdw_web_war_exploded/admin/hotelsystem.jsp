<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Destination"%>
<%@page import="model.DAO"%>
<%@page import="model.Route"%>
<%@page import="model.Coach"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="language" content="en" />

    <!-- blueprint CSS framework -->
    <link rel="stylesheet" type="text/css" href="/resources/css/screen.css" media="screen, projection" />
    <link rel="stylesheet" type="text/css" href="/resources/css/print.css" media="print" />
    <!--[if lt IE 8]>
    <link rel="stylesheet" type="text/css" href="/resources/css/ie.css" media="screen, projection" />
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/form.css" />

    <title>Rezervační systém - rezervace hotelu</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - rezervace hotelu</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <p>Rezervace provedené hotelem.</p>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Ulice</th>
                    <th>Číslo domu</th>
                    <th>Město</th>
                    <th>Celková cena</th>
                    <th>Doprava:</th>
                    <th>Z</th>
                    <th>Cas odjezdu</th>
                    <th>Do</th>
                    <th>Cas prijezdu</th>
                    <th>Cena cesty</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="r" items="${requestScope['reservations']}">
                    <tr>
                        <td>${r.idReservation}</td>
                        <td>${r.firstName}</td>
                        <td>${r.surName}</td>
                        <td>${r.street}</td>
                        <td>${r.houseNumber}</td>
                        <td>${r.city}</td>
                        <td>${r.totalPrice}</td>
                        <td/>
                        <td>${r.from}</td>
                        <td>${r.departureTime}</td>
                        <td>${r.to}</td>
                        <td>${r.arrivalTime}</td>
                        <td>${r.routePrice}</td>
                        <td><a href="/admin/hotelsystem?coachId=${r.idCoach}">update</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br><br>

            <c:forEach var="c" items="${requestScope['coaches']}">
                <%
                    DAO dao = DAO.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
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
                        <td>
                            <form method="post" action="/admin/hotelsystem">
                                <input type="hidden" value="${c.id}" name="coachId" />
                                <input type="hidden" value="${requestScope['oldCoachId']}" name="oldCoachId" />
                                <input type="submit" value="OK" />
                            </form>
                        </td>
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

