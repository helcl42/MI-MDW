<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>

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

    <title>Rezervační systém - dobití kreditu</title>
</head>
<body>
<%
    String coachId = request.getParameter("coachId");
%>

<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém - dobiti kreditu</div>
    </div>
    <div class="container">
        <div id="content">
            <div class="form">
                <jsp:include page="/WEB-INF/jsp/menu.jsp" />
                <jsp:include page="/WEB-INF/jsp/messages.jsp" />
                <form action="/customer/topupcredit<%
                                    if (coachId != null) {
                                        out.write("?coachId=" + coachId);
                                    }
                              %>" method="post">
                    <table>
                        <tr>
                            <td>Částka:</td>
                            <td><input type="text" name="credit" value="${requestScope['tmpCredit']}" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Dobít" /></td>
                            <td>&nbsp;</td>
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
