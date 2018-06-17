<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/9
  Time: 23:31
  To change this template use ile | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function display(){
            alert("Added Successfully");
        }
    </script>
</head>
<body>
<form action="NotesPage.htm" method="post">
    <div style="text-align: center;">
        <table style="margin: auto">
            <tr>
                <td style="padding-top: 15px">
                    <img src="/image/Frank/qing.jpg" style="margin-left: 100px;" width="400px"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    City: <input name="CityId" type="text" class="demo-input"style="margin-left:125px;" placeholder=" Title"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                   Title: <input name="title" type="text" class="demo-input"style="margin-left:118px;" placeholder=" Title"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                   Content: <textarea name="content" type="" class="demo-input"style="margin-left:100px;width:400px;height:120px;text-align:justify" placeholder="Content" id="test1-1"></textarea>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                   Email: <input name="email" type="text" class="demo-input"style="margin-left:118px;" placeholder="Email" />
                </td>
            </tr>
            <tr>
                <td style="padding-top: 10px">
                    <input type="submit" value="Submit" onclick="display()"  style="margin-left:260px;background: #009688;width: 80px;height:40px;line-height: 40px;font-size: 18px"/>
                </td>
            </tr>

        </table>
    </div>
</form>
</body>
</html>
