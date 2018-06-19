<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link  href="css/Frank/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body style="margin: 0">
<div class="background">
    <form action="SceneryPage.htm" method="post">
        <ul class="nav">
            <li><a href="HomePage.htm">Home</a></li>
            <li class="drop-down"><a href="#">Hot Cities</a>
                <ul class="drop-down-content">
                    <c:forEach items="${cityList}" var="city">
                        <li><input class="dropdown_button" type="submit" value="${city.cName}" name="cName"></li>
                    </c:forEach>
                </ul>
            </li>
            <li><a href="NotesPage.htm">Notes</a></li>
            <li><a href="#">Travelling</a></li>
            <li><a href="#">About Us</a></li>
        </ul>
    </form>
    <form action="CityDetailPage.htm/search.htm" method="post">
        <div  class="search" id="box">
            <input type="text" name="rName"  placeholder="Please Enter the Resorts">
            <button id="search" type="submit">Search</button>
        </div>
    </form>
</div>
</body>
</html>
