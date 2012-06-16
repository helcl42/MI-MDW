<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/21/12
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<jsp:include page="messages.jsp"/>
<h2>Dobit</h2>

<form action="dobit" method="post">
    <table>
        <tr>
            <td>Castka: &nbsp;</td>
            <td><input type="text" name="money"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><input type="submit" value="OK"/></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</form>
</body>
</html>
