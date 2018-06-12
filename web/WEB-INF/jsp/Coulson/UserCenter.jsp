<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name : Skeleton
Description: A two-column, fixed-width design with dark color scheme.
Version : 1.0
Released : 20130902

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%String path = request.getContextPath();%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>UserCenter</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/image/HomePage/favicon.ico"/>

    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet"/>
    <link href="<%=path%>/css/Coulson/default.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="<%=path%>/css/Coulson/fonts.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="<%=path%>/js/Coulson/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/Coulson/stickySidebar.js"></script>

</head>
<body>
<div id="page" class="container">
    <div id="header">
        <div id="logo">
            <a href="" title="Change your avatar">
                <img src="${user_profile}" alt="User Profile"/>
            </a>
            <h1><a href="#">${login_name}</a></h1>
            <form action="/fileUpload.htm" method="post" enctype="multipart/form-data">
                <input class="input-file" type="file" name="file">
                <input type="submit" value="Upload">
            </form>
        </div>
        <div id="menu">
            <ul>
                <li class="current_page_item"><a href="#" accesskey="1" title="">Homepage</a></li>
                <li><a href="#" accesskey="2" title="">Our Clients</a></li>
                <li><a href="#" accesskey="3" title="">About Us</a></li>
                <li><a href="#" accesskey="4" title="">Careers</a></li>
                <li><a href="#" accesskey="5" title="">Contact Us</a></li>
            </ul>
        </div>
    </div>
    <div id="main">
        <div id="banner">
            <img src="images/pic01.jpg" alt="" class="image-full"/>
        </div>
        <div id="welcome">
            <div class="title">
                <h2>Fusce ultrices fringilla metus</h2>
                <span class="byline">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue</span>
            </div>
            <p>This is <strong>Privy</strong>, a free, fully standards-compliant CSS template designed by <a
                    href="http://templated.co" rel="nofollow">TEMPLATED</a>. The photos in this template are from <a
                    href="http://fotogrph.com/"> Fotogrph</a>. This free template is released under the <a
                    href="http://templated.co/license">Creative Commons Attribution</a> license, so you're pretty much
                free to do whatever you want with it (even use it commercially) provided you give us credit for it. Have
                fun :) </p>
            <ul class="actions">
                <li><a href="#" class="button">Etiam posuere</a></li>
            </ul>
        </div>
        <div id="featured">
            <div class="title">
                <h2>Maecenas lectus sapien</h2>
                <span class="byline">Integer sit amet aliquet pretium</span>
            </div>
            <ul class="style1">
                <li class="first">
                    <p class="date"><a href="#">Jan<b>05</b></a></p>
                    <h3>Amet sed volutpat mauris</h3>
                    <p><a href="#">Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et,
                        tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend.
                        Etiam non felis. Donec ut ante.</a></p>
                </li>
                <li>
                    <p class="date"><a href="#">Jan<b>03</b></a></p>
                    <h3>Sagittis diam dolor amet</h3>
                    <p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas
                        at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue
                        rutrum.</a></p>
                </li>
                <li>
                    <p class="date"><a href="#">Jan<b>01</b></a></p>
                    <h3>Amet sed volutpat mauris</h3>
                    <p><a href="#">Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et,
                        tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend.
                        Etiam non felis. Donec ut ante.</a></p>
                </li>
                <li>
                    <p class="date"><a href="#">Dec<b>31</b></a></p>
                    <h3>Sagittis diam dolor amet</h3>
                    <p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas
                        at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue
                        rutrum.</a></p>
                </li>
            </ul>
        </div>
        <div id="copyright">
            <span>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a></span>
            <span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</span>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
    <%--$(document).ready(function() {--%>
        <%--$('#logo').stickySidebar({--%>

            <%--sidebarTopMargin: 20,--%>
            <%--footerThreshold: 100--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
