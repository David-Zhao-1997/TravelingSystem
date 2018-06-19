<%@ page import="beans.Users" %>
<%@ page import="beans.City" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小龍ge
  Date: 2018/5/7
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>HotelPage</title>
    <link rel="shortcut icon" href="../../../image/HomePage/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../../../css/Nick/HotelPage.css"/>
    <script src="../../../js/Nick/laydate.js"></script>
    <script type="text/javascript">

        lay('#version').html('-v'+ laydate.v);
        laydate.render({
            elem: '#test1-1'
            ,lang: 'en'
        });

        laydate.render({
            elem: '#test1' //指定元素
        });
    </script>

</head>
<%
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(
             "yyyy-MM-dd HH:mm:ss");
       java.util.Date currentTime = new java.util.Date();
       String time = simpleDateFormat.format(currentTime).toString();
%>
<body>
<div id="div3">
    <ul id="ul3">
        <li>
            <a href="HomePage.htm">Home</a>
        </li>
        <li>
            <a href="FoodPage.htm">Food</a>
        </li>
    </ul>
    <table>
        <tr>
            <td>
                <img src="image/Nick/h_dw.jpg" width="20px" height="20px"/>
            </td>
            <td>
                <%=session.getAttribute("city")%>
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
                <img src="image/Nick/h_sz.jpg" width="20px" height="20px"/>
            </td>
            <td>
                <%=time%>
            </td>
        </tr>
    </table>
</div>
<hr/>
    <div width="100%" height="100%" style="border-style: dot-dash;border-color: aqua">
        <font style="font-family: Great Vibes,cursive;font-size: 50px;color: aqua">FALCON SPACE</font>
    </div>
    <div>
        <img src="image/Nick/h_b.jpg" width="100%" height="50%"/>
    </div>

    <table style="position: absolute;right: 10px;top:70%">
        <th>
            Recommended Hotel
        </th>
        <tr>
            <td>
                <img src="image/Nick/h16.jpg" width="200px" height="200px"/>
            </td>
        </tr>
        <tr>
            <td>
                <img src="image/Nick/h15.jpg" width="200px" height="200px"/>
            </td>
        </tr>
        <tr>
            <td>
                <img src="image/Nick/h3.jpg" width="200px" height="200px"/>
            </td>
        </tr>
        <tr>
            <td>
                <img src="image/Nick/h18.jpg" width="200px" height="00px"/>
            </td>
        </tr>
    </table>

<div style="position: absolute;left:10%;top:20%;background: black;opacity: 0.8;width: 300px;height: 300px;">
    <table style="padding-top: 20px;padding-left: 15px;color: white;text-align: center">
        <tr>
            <td style="padding-bottom: 5px;font-size: 20px">
                Search Hotel
            </td>
        </tr>
        <tr>
            <td>
                <form id="form1"  action="HotelPage.htm" method="post">
                    <select name="cityId" style="width: 262px;height: 40px">
                        <option value="">Choose city</option>
                        <c:forEach items="${cityList}" var="city">
                            <option value="${city.cityId}">${city.cName}</option>
                        </c:forEach>
                    </select>
            <%--</td>--%>
        </tr>
        <tr>
            <td>
                <input type="text" style="width: 262px;height: 40px" placeholder="Check-in time" id="test1-1">
            </td>
        </tr>
        <tr>
            <td  style="padding-top: 15px">
                <input type="text" style="width: 262px;height: 40px" placeholder="Check-out time" id="test1">
            </td>
        </tr>
        <tr>
            <td style="padding-top: 15px">
                <input type="submit" value="Search"  style="background: yellow;width: 262px;min-width: 38px;line-height: 38px;font-size: 20px"/>
            </td>
        </tr>
    </table>
    </form>
</div>
    <hr/>

    <table border="1px" style="width: 80%;border-style: hidden; align-content: center;position: absolute;top: 70%;background: white;">
        <c:forEach items="${hotelList}" var="hotel">
            <tr>
                <td style="width: 300px;height: 300px;">
                    <img src="${hotel.pictures}" style="width: 300px;height: 300px"/>
                </td>
                <td>
                    <table style="padding-left: 50px;width: 100%;">
                        <tr>
                            <td style="padding-top: 25px">
                                Hotel Name:
                            </td>
                            <td style="padding-top: 25px;font-size: 30px">
                                    ${hotel.hName}
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top: 25px;">
                                Average Price:
                            </td>
                            <td style="padding-top: 25px;font-size: 30px;color: orangered">
                                    ${hotel.avgPrice}$
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top: 25px">
                                Visits:
                            </td>
                            <td style="padding-top: 25px">
                                    ${hotel.viewCount}
                            </td>
                        </tr>

                        <tr>
                            <td style="padding-top: 25px">
                                    ${hotel.description}
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td style="padding-right: 20px">
                                <form id="form2" action="BookingPage.htm" method="get">
                                    <input name="bookHotelID" type="hidden" value="${hotel.hotelId}">
                                    <input type="submit" value="Book Hotel"  style="background:orangered;width: 262px;min-width: 38px;line-height: 38px;
        font-size: 20px;"/>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
