<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/6
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <!--
        body,table{
            font-size:15px;
        }
        table{
            table-layout:fixed;
            empty-cells:show;
            border-collapse: collapse;
            margin:0 auto;
        }
        td{
            height:60px;
        }
        h1,h2,h3{
            font-size:12px;
            margin:0;
            padding:0;
        }
        .title { background: #FFF; border: 1px solid #9DB3C5; padding: 1px; width:90%;margin:20px auto; }
        .title h1 { line-height: 31px; text-align:center;  background: #2F589C ; background-repeat: repeat-x; background-position: 0 0; color: #FFF; }
        .title th, .title td { border: 1px solid #CAD9EA; padding: 5px; }
        table.t1{
            border:1px solid #cad9ea;
            color:#666;
        }
        table.t1 th {

            background-repeat:repeat-x;
            height:30px;
        }
        table.t1 td,table.t1 th{
            border:1px solid #cad9ea;
            padding:0 1em 0;
        }
        table.t1 tr.a1{
            background-color:#f5fafe;
        }

         .button1  {
             background-color: #2d6ca2; /* Green */
             border: none;
             color: white;
             padding: 10px 20px;
             text-align: center;
             text-decoration: none;
             display: inline-block;
             font-size: 18px;
             margin: 4px 2px;
             cursor: pointer;
             -webkit-transition-duration: 0.4s; /* Safari */
             transition-duration: 0.4s;
             border-radius: 50%;
         }
        .button2  {
            background-color: #2d6ca2; /* Green */
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 18px;
            margin: 4px 2px;
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            border-radius: 50%;
        }
        .button1:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
        }
        .button2:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
        }
    </style>
</head>
<body>
<div class="background">
    <div class="title">
        <h1 style="font-size: 20px">Hot Resorts</h1>
    </div>

    <form float="left" action="CityDetailPage.htm/showbylevel.htm" style="margin-left:1100px;margin-top:1px;" method="post">
        <button class="button1" >By Levels</button>

    </form>
        <table  width="90%" id="mytab"  border="1" class="t1">
        <thead>
        <th width="10%">Resort Name</th>
        <th width="30%">Descriptions</th>
        <th width="10%">Price</th>
        <th width="40%">Picture</th>
        <th width="10%">Level</th>
        </thead>
        <c:forEach items="${resortList}" var="resort">
<tr>
            <td>${resort.rName}</td>
            <td>${resort.description}</td>
            <td>${resort.price}</td>
            <td><img src="${resort.pictures}" style="width:450px;height:250px"/></td>
            <td>${resort.level}</td>
</tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
