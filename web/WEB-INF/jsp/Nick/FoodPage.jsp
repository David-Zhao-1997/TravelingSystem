<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小龍ge
  Date: 2018/5/26
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FoodPage</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>css/Nick/FoodPage.css"/>
    <link rel="shortcut icon" href="../../../image/HomePage/favicon.ico"/>
    <script type="text/javascript">
        window.onload = function () {
            var lis = document.getElementsByTagName("li");
            for (var i = 0; i < lis.length; i++) {
                lis[i].onmouseover = function () {
                    this.getElementsByTagName("div")[0].style.display = "block";
                };
                lis[i].onmouseout = function () {
                    this.getElementsByTagName("div")[0].style.display = "none";
                }
            }
        }

        function showPic(event, sUrl) {
            var x, y;
            x = event.clientX;
            y = event.clientY;
            // document.getElementById("Layer1").style.left = x+280+'px';
            // document.getElementById("Layer1").style.top = y+2+'px';
            document.getElementById("Layer1").innerHTML = "<img width='500px' border='0' src='/image/Nick/" + sUrl + "'>";
            document.getElementById("Layer1").style.display = "";
        }

        function hiddenPic() {
            document.getElementById("Layer1").innerHTML = "";
            document.getElementById("Layer1").style.display = "none";
        }

    </script>
    <%
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        java.util.Date currentTime = new java.util.Date();
        String time = simpleDateFormat.format(currentTime).toString();
    %>
</head>
<body>
<form id="form1" action="FoodPage.htm" method="post">
    <input type="text" name="fName" placeholder="" style="border-color:sienna; width: 50%;height: 8%;font-size: 25px;position: absolute;left:20%;top:15%"/>
    <input type="submit" value="Search" style="background: sienna;border-color:sienna;color: darkgrey;font-size:25px;width: 13%;height: 8%;position: absolute;left:70%;top:15%"/>
</form>
<img src="image/Nick/f_b1.jpg" style="width: 85%;position: absolute;top: 30%;left:10%">
<div id="div1">
    <ul id="ul1">
        <li id="li1">
            <a href="#">Classification of food&nbsp&nbsp&nbsp三</a>
            <div>
                <a href="#" onmouseover="showPic(event,'f_c.jpg')" onmouseout="hiddenPic()">Chinese food</a>
                <a href="#" onmouseover="showPic(event,'f_f.jpg')" onmouseout="hiddenPic()">Fast food</a>
                <a href="#" onmouseover="showPic(event,'f4.jpg')" onmouseout="hiddenPic()">Hot pot</a>
                <a href="#" onmouseover="showPic(event,'f_x.jpg')" onmouseout="hiddenPic()">Western food</a>
                <a href="#" onmouseover="showPic(event,'f_h.jpg')" onmouseout="hiddenPic()">Seafood</a>
                <a href="#" onmouseover="showPic(event,'f_z.jpg')" onmouseout="hiddenPic()">Buffet</a>
                <a href="#" onmouseover="showPic(event,'f_s.jpg')" onmouseout="hiddenPic()">Barbecue</a>
                <a href="#" onmouseover="showPic(event,'f_t.jpg')" onmouseout="hiddenPic()">Sweetmeats</a>
                <a href="#" onmouseover="showPic(event,'f1.jpg')" onmouseout="hiddenPic()">Japanese cuisine</a>
            </div>
        </li>
    </ul>
</div>
<div id="div2">
    <ul id="ul2">
        <li>
            <a href="#">Food hot list</a>
        </li>
        <li>
            <a href="#">New food list</a>
        </li>
        <li>
            <a href="#">Food recommendation</a>
        </li>
    </ul>
</div>
<div id="div3">
    <ul id="ul3">
        <li>
            <a href="HomePage.htm">Home</a>
        </li>
        <li>
            <a href="HotelPage.htm">Hotel</a>
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
<div style="background: #8a6d3b;width: 100%;font-size: 30px;text-align: center;position: absolute;top: 100%;">
    Food hot list
</div>
<table width="100%" style="position: absolute;top: 110%;text-align: center">
    <tr>
        <td>
            <img src="image/Nick/f1.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f3.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f4.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f5.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f6.jpg" style="width: 200px;height: 200px"/>
        </td>
    </tr>
</table>
<div style="background: #8a6d3b;width: 100%;font-size: 30px;text-align: center;position: absolute;top: 145%;">
    Food recommendation
</div>
<table width="100%" style="position: absolute;top: 155%;text-align: center">
    <tr>
        <td>
            <img src="image/Nick/f5.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f7.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f8.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f9.jpg" style="width: 200px;height: 200px"/>
        </td>
        <td>
            <img src="image/Nick/f10.jpg" style="width: 200px;height: 200px"/>
        </td>
    </tr>
</table>

<div id="div4" style="position: absolute;top:190%;background: black;opacity: 0.8;width: 100%">
    <table style="width: 100%;align-content: center">
        <c:forEach items="${foodList}" var="food">
            <tr>
                <td style="width: 300px;height: 300px">
                    <img src="${food.pictures}" style="width: 300px;height: 300px"/>
                </td>
                <td>
                    <table style="padding-left: 50px;width: 100%;color: white">
                        <tr>
                            <td style="padding-top: 25px">
                                 Name:
                            </td>
                            <td style="padding-top: 25px;font-size: 30px">
                                    ${food.fName}
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top: 25px;">
                                Average Price:
                            </td>
                            <td style="padding-top: 25px;font-size: 30px;color: orangered">
                                    ${food.avgPrice}$
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top: 25px">
                                Visits:
                            </td>
                            <td style="padding-top: 25px">
                                    ${food.viewCount}
                            </td>
                        </tr>

                        <tr>
                            <td style="padding-top: 25px">
                                    ${food.description}
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
                                <form id="form2" action="BookFoodPage.htm" method="get">
                                    <input name="bookFName" type="hidden" value="${food.fName}">
                                    <input type="submit" value="Book"  style="background:orangered;width: 262px;min-width: 38px;line-height: 38px;
        font-size: 20px;"/>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>
    <hr/>
</div>
<div id="Layer1" style="position:absolute;top: 40%;left: 40%;"></div>



</body>
</html>