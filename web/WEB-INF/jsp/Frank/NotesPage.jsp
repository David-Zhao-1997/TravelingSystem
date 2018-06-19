<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <!--
        body, table {
            font-size: 15px;
        }

        table {
            table-layout: fixed;
            empty-cells: show;
            border-collapse: collapse;
            margin: 0 auto;
        }

        td {
            height: 60px;
        }

        h1, h2, h3 {
            font-size: 12px;
            margin: 0;
            padding: 0;
        }

        .title {
            background: #FFF;
            border: 1px solid #9DB3C5;
            padding: 1px;
            width: 90%;
            margin: 20px auto;
        }

        .title h1 {
            line-height: 50px;
            text-align: center;
            background: #8a6d3b ;
            background-repeat: repeat-x;
            background-position: 0 0;
            color: #FFF;
        }

        .title th, .title td {
            border: 1px solid #CAD9EA;
            padding: 5px;
        }

        table.t1 {
            border: 1px solid #cad9ea;
            color: #666;
        }

        table.t1 th {

            background-repeat: repeat-x;
            height: 30px;
        }

        table.t1 td, table.t1 th {
            border: 1px solid #cad9ea;
            padding: 0 1em 0;
        }

        table.t1 tr.a1 {
            background-color: #f5fafe;
        }

        .button1 {
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

        .button2 {
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
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }

        .button2:hover {
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
        }

        .button {
            border: none;
            color: white;
            padding: 8px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .b1 {
            background-color: white;
            color: black;
            border: 2px solid #555555;
        }

        .b2 {
            background-color: white;
            color: black;
            border: 2px solid #555555;
        }

        .b1 {
            background-color: #555555;
            color: white;
        }

        input {
            width: 260px;
            border: 1px solid #e2e2e2;
            height: 30px;
            float: left;
            background-image: url('/image/Frank/glass.jpg');
            background-repeat: no-repeat;
            background-size: 25px;
            background-position: 5px center;
            padding: 0 0 0 40px;
        }
    </style>
</head>
<body>
<div class="background">
    <div class="title">
        <h1 style="font-size: 20px">Notes</h1>
    </div>


    <form method="get" action="/Notes.htm" style="float:left;margin-left:1100px;margin-bottom:20px;">
        <button id="add" type="submit" class="button b2">Add Your Note</button>
    </form>
    <table width="90%" id="mytab" border="1" class="t1">
        <thead>
        <th width="5%">City</th>
        <th width="8%">Title</th>
        <th width="35%">Content</th>
        <th width="12%">Email</th>
        <th width="10%">Publishing Date</th>
        <th width="5%">Likes</th>
        <th width="5%">State</th>
        <th width="12%">Choices</th>
        </thead>
            <c:forEach items="${NoteList}" var="Note">
                <tr>
                    <td>${Note.cityId}</td>
                    <td>${Note.title}</td>
                    <td>${Note.content}</td>
                    <td>${Note.email}</td>
                    <td>${Note.editTime}</td>
                    <td>${Note.up}</td>
                    <td>${Note.state}</td>
                    <td><a href="/Update.htm?noteId=${Note.noteId}" style=" width:70px;height:22px;">Update</a>
                        <a href="/DeleteNote.htm?noteId=${Note.noteId}" style=" width:70px;height:22px;">Delete</a>

                    </td>
                </tr>
            </c:forEach>


    </table>
</div>
</body>
</html>
