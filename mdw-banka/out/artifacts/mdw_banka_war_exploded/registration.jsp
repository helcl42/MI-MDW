<%--
  Created by IntelliJ IDEA.
  User: lubos
  Date: 4/21/12
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Banka pro fit-mdw-ws11-102-6</title>
</head>
<body>
<jsp:include page="messages.jsp"/>
<h2>Přihlášení</h2>

<form action="registration" method="post">
    <table>
        <tr>
            <td>Username: &nbsp;</td>
            <td><input type="text" name="username"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Jmeno: &nbsp;</td>
            <td><input type="text" name="name"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Prijmeni: &nbsp;</td>
            <td><input type="text" name="surname"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Heslo: &nbsp;</td>
            <td><input type="password" name="password"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Potvrzeni hesla: &nbsp;</td>
            <td><input type="password" name="passwordagain"/></td>
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

