<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
        <style type="text/css">
         .search{
              width: 380px;
              margin: 30px auto;
              font-family: 'Microsoft YaHei';
              font-size: 14px;
         }
        input{
            width: 260px;
            border: 1px solid #e2e2e2;
            height: 30px;
            float: left;
            background-image: url(image/Frank/glass.jpg);
            background-repeat: no-repeat;
            background-size: 25px;
            background-position:5px center;
            padding:0 0 0 40px;
        }
        #search{
            width: 78px;
            height: 30px;
            float: right;
            background: black;
            color: white;
            text-align: center;
            line-height: 32px;
            cursor: pointer;
        }

    </style>

</head>
<body>
<div  class="search" id="box">
    <input type="text" name="search" placeholder="Please Enter the City">
    <div id="search" >Search</div>
</div>
</body>
</html>
