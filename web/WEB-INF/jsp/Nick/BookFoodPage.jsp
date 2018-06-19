<%--
  Created by IntelliJ IDEA.
  User: 小龍ge
  Date: 2018/6/17
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/css/Nick/BookFoodPage.css"/>
</head>
<body>
<img src="image/Nick/f_b.jpg" width="100%"/>
<form action="FoodPage.htm" method="get">
    <div style="position: absolute;left:35%;top:20%;background: black;opacity: 0.8;width: 300px;height: 500px;padding-left: 35px">
        <table style="margin: auto">
            <tr>
                <td style="padding-top: 15px;text-align: center">
                    <img src="${food.pictures}" width="200px"/>
                </td>
                <td style="padding-top: 15px">
                    ${food.fName}
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="text" class="demo-input" placeholder="Your name"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="text" class="demo-input" placeholder=" Yuor phone number"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="text" class="demo-input" placeholder="Number of the guest"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="text" class="demo-input" placeholder="Scheduled time" id="test1-1"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="submit" value="Book" onclick="display_message()"  style="background: yellow;width: 262px;min-width: 38px;line-height: 38px;font-size: 20px"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
