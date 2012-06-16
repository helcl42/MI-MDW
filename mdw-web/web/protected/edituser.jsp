<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.RoleEnum"%>
<%@page import="model.User"%>
<%@page import="model.Customer"%>
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

    <title>Rezervační systém - Editace uživatele</title>
</head>
<body>
<div class="container" id="page">

    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <h1>Rezervační systém - Editace uživatele</h1>
    </div>

    <jsp:include page="/WEB-INF/jsp/menu.jsp" />

    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <h2>Editace profilu</h2>

            <% User usr = (User) request.getSession().getAttribute("user");%>

            <h3>Změna jména nebo příjmení</h3>
            <form method="post" action="/protected/edituser">
                <input type="hidden" name="id" value="<%= usr.getId()%>" />
                <table>
                    <tr>
                        <td>Jméno:</td>
                        <td><input type="text" name="name" value="<%= usr.getName()%>"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Příjmení:</td>
                        <td><input type="text" name="surname" value="<%= usr.getSurname()%>"/></td>
                        <td></td>
                    </tr>
                    <%
                        if (usr != null) {
                            if (usr.getRole() == RoleEnum.CUSTOMER) {
                    %>
                    <tr>
                        <td>Číslo účtu:</td>
                        <td><input type="text" name="account" value="<%= ((Customer) usr).getAccount()%>"/></td>
                        <td></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>
                </table>
            </form>

            <h3>Změna hesla</h3>
            <form method="post" action="/protected/changepassword">
                <input type="hidden" name="id" value="<%= usr.getId()%>" />
                <table>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password1" value=""/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password2" value=""/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
