<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/21/12
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="entity.Account" %>
<%@page import="entity.Customer" %>
<%@page import="entity.DAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%
    Customer cust = (Customer) request.getSession().getAttribute("customer");
    DAO dao = DAO.getInstance();

    Account acc = dao.getEntity(cust.getAccount());
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Banka pro fit-mdw-ws11-102-6</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<jsp:include page="messages.jsp"/>
<h2>Stav konta</h2>

<p><% out.write("Na vasem uctu cislo " + acc.getId().toString() + " je:" + acc.getBalance().toString() + " Kč"); %></p>
</body>
</html>

