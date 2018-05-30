<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<center><p>传值测试</p></center>
<form action="index.htm" method="post">
    <table>
        <tr>
            <td>email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="uPass"></td>
        </tr>
        <tr>
            <td>username</td>
            <td><input type="text" name="uName"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
