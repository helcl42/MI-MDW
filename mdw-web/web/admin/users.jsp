<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:40 AM
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

    <title>Rezervační systém - uživatelé</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - uzivatele</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <h2>Uživatelé</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Username</th>
                    <th>Číslo účtu</th>
                    <th>Role</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <c:forEach var="u" items="${requestScope['customers']}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.name}</td>
                        <td>${u.surname}</td>
                        <td>${u.username}</td>
                        <td>${u.account}</td>
                        <td>${u.role}</td>
                        <td><a href="/admin/deleteUser?id=${u.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

            <h2>Admins</h2>
            <table border="1" cellspacing="2" cellpadding="5">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <c:forEach var="u" items="${requestScope['admins']}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.name}</td>
                        <td>${u.surname}</td>
                        <td>${u.username}</td>
                        <td>${u.role}</td>
                        <td><a href="/protected/edituser?id=${u.id}">Edit</a></td>
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
