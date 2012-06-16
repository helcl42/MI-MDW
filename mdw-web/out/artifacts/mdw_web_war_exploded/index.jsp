<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/20/12
  Time: 1:18 AM
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

    <title>Rezervační systém</title>
</head>
<body>
<div class="container" id="page">
    <div id="header">
        <jsp:include page="/WEB-INF/jsp/login-info.jsp" />
        <div id="logo">Rezervační systém</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />

    <div class="container">
        <div id="content">
            <jsp:include page="/WEB-INF/jsp/messages.jsp" />
            <p>Vítejte v našem rezervačním systému. Můžete si zde rezervovat místo v autobuse na své oblíbené trase.</p>
            <p>Pro inicializaci aplikace přejděte na <a href="/init">inicializační stránku</a>.</p>
            <p>Poté se můžete přihlásit jako administrátor (username admin, heslo admin). Do aplikace se také přidá
                několik destinací, tras a spojů. Incializace by se měla pouštět pouze jednou.</p>
            <p>Můžete také všechna data <a href="/deletedata">smazat</a>.</p>
        </div>
        <div id="footer">
            Copyright &copy; 2011<br/>
            All Rights Reserved.<br/>
        </div>
    </div>
</div>
</body>
</html>
