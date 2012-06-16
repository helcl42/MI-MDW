<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:38 AM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <title>Rezervační systém - destinace</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - destinace</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />

            <h2>Nová destinace</h2>
            <form action="destination" method="post">
                Jméno:<br />
                <input type="text" name="name" value="${requestScope['name']}" /><br />
                Země:<br />
                <input type="text" name="country" value="${requestScope['country']}" /><br />
                <input type="submit" value="OK" />
            </form>

            <h2>Výpis destinací</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Jméno</th>
                    <th>Země</th>
                </tr>
                </thead>
                <c:forEach var="dest" items="${requestScope['destinations']}">
                    <tr>
                        <td>${dest.id}</td>
                        <td>${dest.name}</td>
                        <td>${dest.country}</td>
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
