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
    <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>css/Nick/HotelPage.css"/>
    <script src="../../../js/Nick/laydate.js"></script>
    <script type="text/javascript">
        function login() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/users/login" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
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
<table>
    <tr>
        <td>
            <div style="width:100%;background: darkgrey" >
                City|Weather|<%=time%>
            </div>
        </td>
    </tr>
</table>
    <div width="100%" height="100%" style="border-style: dot-dash;border-color: aqua">
        <font style="font-family: Great Vibes,cursive;font-size: 50px;color: aqua">FALCON SPACE</font>
    </div>
    <div class="div1">
        <img src="image/Nick/h4.jpg" width="100%" height="50%"/>
    </div>
    <div style="height: 100%;height: 8%;background: darkgrey;text-align: center;font-size: 30px">
        The most popular hotels
    </div>
    <table style="text-align: center;margin: auto">
        <tr>
            <td style="padding-right: 20px">
                <img src="image/Nick/h1.jpg" width="300px" height="300px"/>
            </td>
            <td style="padding-right: 20px">
                <img src="image/Nick/h1.jpg" width="300px" height="300px"/>
            </td>
            <td style="padding-right: 20px">
                <img src="image/Nick/h1.jpg" width="300px" height="300px"/>
            </td>
            <td style="padding-right: 20px">
                <img src="image/Nick/h1.jpg" width="300px" height="300px"/>
            </td>
        </tr>
        <tr>
            <td>
                <center>Hotel Name</center>
            </td>
            <td>
                <center>Hotel Name</center>
            </td>
            <td>
                <center>Hotel Name</center>
            </td>
            <td>
                <center>Hotel Name</center>
            </td>
        </tr>
    </table>
<hr/>
<div width="200px" height="200px" style="position: absolute;left:10%;top:20%;background: black;opacity: 0.8;width: 300px;height: 270px;">
    <table style="padding-top: 20px;padding-left: 15px">
        <tr>
            <td>
                <form id="form1"  action="HotelPage.htm" method="post">
                    <select  name="cityId" class="demo-input">
                        <option value="">Choose city</option>
                        <c:forEach items="${cityList}" var="city">
                            <option value="${city.cityId}">${city.cName}</option>
                        </c:forEach>
                    </select>
            <%--</td>--%>
        </tr>
        <tr>
            <td>
                <input type="text" class="demo-input" placeholder="Check-in time" id="test1-1">
            </td>
        </tr>
        <tr>
            <td  style="padding-top: 15px">
                <input type="text" class="demo-input" placeholder="Check-out time" id="test1">
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

        <table width="100%">
            <tr>
                <td><div style="font-size: 30px">The search results are as follows:</div></td>
            </tr>
        </table>
    <hr/>
        <table style="width: 100%;align-content: center">
            <c:forEach items="${hotelList}" var="hotel">
                <tr>
                    <td style="width: 300px;height: 300px">
                        <img src="${hotel.pictures}" style="width: 300px;height: 300px"/>
                    </td>
                    <td>
                        <table style="padding-left: 50px;width: 100%">
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
        <hr/>
</body>
</html>
