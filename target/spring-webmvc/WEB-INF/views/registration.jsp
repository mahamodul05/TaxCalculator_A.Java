<%--
  Created by IntelliJ IDEA.
    User: MAHADI
  Date: 10/19/2022
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form method="post" action="register/v2">
        <label for="firstname">Firstname:</label>
        <input type="text" name="firstname" id="firstname"/>

        <br><br>

        <label for="lastname">Lastname:</label>
        <input type="text" name="lastname" id="lastname"/>

        <br><br>

        <input type="submit" value="Register">
    </form>

</body>
</html>
