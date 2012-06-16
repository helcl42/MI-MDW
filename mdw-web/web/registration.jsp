<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="language" content="en"/>

    <!-- blueprint CSS framework -->
    <link rel="stylesheet" type="text/css" href="/resources/css/screen.css" media="screen, projection"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/print.css" media="print"/>
    <!--[if lt IE 8]>
    <link rel="stylesheet" type="text/css" href="/resources/css/ie.css" media="screen, projection"/>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/form.css"/>

    <title>Rezervační systém - registrace</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp"/>
        <div id="logo">Rezervační systém - registrace</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>

    <div class="container">
        <div id="content">
            <div class="form">
                <jsp:include page="/WEB-INF/jsp/messages.jsp"/>
                <form action="registration" method="post">
                    <table>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username" value="${requestScope['tmpUsername']}"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>Jméno:</td>
                            <td><input type="text" name="name" value="${requestScope['tmpName']}"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>Příjmení:</td>
                            <td><input type="text" name="surname" value="${requestScope['tmpSurname']}"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>Číslo účtu:</td>
                            <td><input type="text" name="account" value="${requestScope['tmpAccount']}"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>Heslo:</td>
                            <td><input type="password" name="password1"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>Potvrzeni Hesla:</td>
                            <td><input type="password" name="password2"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td><input type="submit" value="OK"/></td>
                        </tr>
                    </table>
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
