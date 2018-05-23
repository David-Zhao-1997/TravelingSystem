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
</head>
<body>
    <div style="width:100%;background: darkgrey" >
        City|Weather|Date
    </div>
    <img src="img/Nick/a.jpg" style="width: 60px;height: 100px"/>
    <table width="50%" border="0" align="center">
        <tr>
            <td style="vertical-align:middle; text-align:right;">
                Please Select city:
            </td>
            <td>
                <select name="city" value="" style="background: beige;width: 100px;height: 30px">>
                    <option value="Qingdao" ></option>
                    <option value="Qingdao" >Qingdao</option>
                    <option value="2" >Jinan</option>
                    <option value="3" >Shanghai</option>
                    <option value="Qingdao" >Beijing</option>
                    <option value="2" >Yantai</option>
                    <option value="3" >Suzhou</option>
                </select>
            </td>
        </tr>
    </table>
        <table width="100%" style="background: aquamarine">
            <tr>
                <td><div>The search results are as follows:</div></td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <table border="1">
                        <tr>
                            <td>
                                <img src="img/Nick/b.jpg" style="width: 200px;height: 200px"/>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table width="60%" border="1" align="right">
                        <tr>
                            <td>
                                name
                            </td>
                        </tr>
                        <tr>
                            <td>
                                address
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Tel
                            </td>
                        </tr>
                        <tr>
                            <td>
                                details
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
</body>
</html>
