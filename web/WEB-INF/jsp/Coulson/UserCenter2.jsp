<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/7
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Center</title>
</head>
<body>
    <a href="HomePage.htm" target="_self">HomePage</a>
    <form action="/fileUpload.htm" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="Upload">
    </form>
    <img style="width: 150px; height: 150px" src="${user_profile}" alt="User Profile">
</body>
</html>
