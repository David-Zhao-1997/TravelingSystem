<%--
  Created by IntelliJ IDEA.
  User: 小龍ge
  Date: 2018/6/5
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>css/Nick/BookingPage.css"/>
    <script src="../../../js/Nick/laydate.js"></script>
    <script type="text/javascript">
        laydate.render({
            elem: '#test1-1'
            ,lang: 'en'
        });
        laydate.render({
            elem: '#test1' //指定元素
        });
        function display_message() {
            alert("Your order has been submitted");
        }
    </script>
</head>
<body>
    <form action="HotelPage.htm" method="get">
        <div style="text-align: center;">
        <table style="margin: auto">
            <tr>
                <td style="padding-top: 15px">
                    <img src="${hotel.pictures}" width="200px"/>
                </td>
                <td style="padding-top: 15px">
                    ${hotel.hName}
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
                    <input type="text" class="demo-input" placeholder="Check-in time" id="test1-1"/>
                </td>
            </tr>
            <tr>
                <td  style="padding-top: 15px">
                    <input type="text" class="demo-input" placeholder="Check-out time" id="test1">
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    <input type="submit" value="Book" onclick="display_message()"  style="background: yellow;width: 262px;min-width: 38px;line-height: 38px;font-size: 20px"/>
                </td>
            </tr>
        </table>
        </div>
</body>
</html>
