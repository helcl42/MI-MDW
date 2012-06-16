<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="language" content="en"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/screen.css" media="screen, projection"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/print.css" media="print"/>
    <!--[if lt IE 8]>
    <link rel="stylesheet" type="text/css" href="/resources/css/ie.css" media="screen, projection"/>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/form.css"/>

    <title>Rezervační systém - nepovolený přístup</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp"/>
        <div id="logo">Rezervační systém - nepovolený přístup</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>

    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp"/>
            Sem nemáte povolený přístup!
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
