<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/17
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function display() {
            alert("Updated Successfully");
        }
    </script>
</head>
<body>
<form action="UpdateNote.htm" method="post">
    <div style="text-align: center;">
        <table style="margin: auto">
            <tr>
                <td style="padding-top: 15px">
                    <img src="/image/Frank/dao.jpg" style="margin-left: 60px; width:600px; height:300px;"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    City: <input name="cityId" value="${note.cityId}" type="text" class="demo-input"
                                 style="margin-left:200px;" placeholder=" Title"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    Title: <input name="title" value="${note.title}" type="text" class="demo-input"
                                  style="margin-left:192px;" placeholder=" Title"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    Content: <textarea name="content" class="demo-input"
                                       style="margin-left:176px;width:400px;height:120px;text-align:justify"
                                       placeholder="Content" id="test1-1">${note.content}</textarea>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 15px">
                    Email: <input name="email" type="text" value="${note.email}" class="demo-input"
                                  style="margin-left:190px;" placeholder="Email"/>
                </td>
            </tr>
            <tr>
                <td style="padding-top: 10px">
                    <input type="submit" value="Update" onclick="display()"
                           style="margin-left:300px;background: #31b0d5;width: 80px;height:40px;line-height: 40px;font-size: 18px"/>
                </td>
                <input type="hidden" name="noteId" value="${note.noteId}"/>
            </tr>
</table>
    </div>
</form>


</body>
</html>
