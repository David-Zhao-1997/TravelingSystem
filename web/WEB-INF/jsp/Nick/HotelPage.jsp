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
    <title>HotelPage</title>
    <link rel="stylesheet"  type="text/css"  href="css/Nick/HotelPage.css"/>
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
        <font style="font-family: Great Vibes,cursive;font-size: 50px;color: aqua">Donkey Kong</font>
    </div>
    <div class="div1">
        <img src="image/Nick/d.jpg" width="100%" height="50%"/>
    </div>
<div width="30%" height="100%" style="border-style: ridge;">
    <table>
        <tr>
            <td>
                City:
            </td>
            <td>
                    <form id="form1" onsubmit="return false" action="##" method="post">
                        <select  onclick="login()" name="city">
                            <option value="" style="font-size: 20px">Choose city</option>
                            <option value="Qingdao" ></option>
                            <option value="Qingdao" >Qingdao</option>
                            <option value="2" >Jinan</option>
                            <option value="3" >Shanghai</option>
                            <option value="Qingdao" >Beijing</option>
                            <option value="2" >Yantai</option>
                            <option value="3" >Suzhou</option>
                        </select>
                    </form>
            </td>
        </tr>
        <tr>
            <td>
                Check-in time:
            </td>
            <td>
                <input type="text" placeholder="yyyy/mm/dd"/>
            </td>
        </tr>
        <tr>
            <td>
                Check-out time:
            </td>
            <td>
                <input type="text" placeholder="yyyy/mm/dd"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Book"/>
            </td>
        </tr>
    </table>
</div></td>


        <table width="100%" style="background: darkgrey">
            <tr>
                <td><div>The search results are as follows:</div></td>
            </tr>
        </table>
    <hr/>
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
</body>
</html>
