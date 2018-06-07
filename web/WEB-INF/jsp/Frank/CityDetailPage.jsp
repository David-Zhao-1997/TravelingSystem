<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/6
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="background">
    <c:forEach items="${resortList}" var="resort">
        ${resort.rName}
        ${resort.description}
        ${resort.price}
        <img src="${resort.pictures}"/>
        ${resort.level}
    </c:forEach>
</body>
</html>
