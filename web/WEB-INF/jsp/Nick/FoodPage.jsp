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
    <link rel="stylesheet"  type="text/css" href="<%=request.getContextPath()%>css/Nick/FoodPage.css"/>

    <script type="text/javascript">
        window.onload=function(){
            var lis = document.getElementsByTagName("li");
            for(var i=0; i<lis.length; i++){
                lis[i].onmouseover = function(){
                    this.getElementsByTagName("div")[0].style.display = "block";
                };
                lis[i].onmouseout = function(){
                    this.getElementsByTagName("div")[0].style.display = "none";
                }
            }
        }

    </script>
</head>
<body>
    <table width="100%" style="background: lightgray">
        <tr>
            <td>
                city
            </td>
        </tr>
    </table>
        <input type="text" placeholder="" style="border-color:sienna; width: 50%;height: 8%;font-size: 25px;position: absolute;left:20%;top:15%"/>
        <input type="submit" value="Search" style="background: sienna;border-color:sienna;color: darkgrey;font-size:25px;width: 13%;height: 8%;position: absolute;left:70%;top:15%"/>
    <div id="div1">
    <ul id="ul1">
        <li id="li1">
            <a href="#">Classification of food&nbsp&nbsp&nbsp三</a>
            <div>
                <a href="#">Chinese food</a>
                <a href="#">Fast food</a>
                <a href="#">Hot pot</a>
                <a href="#">Western food</a>
                <a href="#">Seafood</a>
                <a href="#">Buffet</a>
                <a href="#">Barbecue</a>
                <a href="#">Sweetmeats</a>
                <a href="#">Japanese cuisine</a>
            </div>
        </li>
    </ul>
    </div>
<div id="div2">
    <ul id="ul2">
        <li>
            <a href="#">Hotel</a>
        </li>
        <li>
            <a href="#">Hotel</a>
        </li>
        <li>
            <a href="#">Hotel</a>
        </li>
        <li>
            <a href="#">Hotel</a>
        </li>
    </ul>
</div>
<div id="div3">
    <ul id="ul3">
        <li>
            <a href="#">Food hot list</a>
        </li>
        <li>
            <a href="#">New food list</a>
        </li>
    </ul>
</div>
<div id="div4">
    <table border="1">
        <tr>
            <td>
                <img src="image/Nick/b.jpg" width="200px" height="200px"/>
            </td>
            <td>
                The details of Hotel
            </td>
        </tr>
    </table>
</div>
</body>
</html>
