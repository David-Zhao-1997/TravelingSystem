<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String path = request.getContextPath();%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <link rel="shortcut icon" href="<%=path%>/image/HomePage/favicon.ico"/>

    <%--<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>--%>
    <link href="<%=path%>/css/Coulson/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path%>/css/Coulson/flexslider.css" rel="stylesheet" >
    <link href="<%=path%>/css/Coulson/styles.css" rel="stylesheet">
    <link href="<%=path%>/css/Coulson/queries.css" rel="stylesheet">
    <link href="<%=path%>/css/Coulson/animate.css" rel="stylesheet">
    <link href="<%=path%>/css/Coulson/login.css" rel="stylesheet"/>
    <link href="<%=path%>/css/Coulson/pickout.css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/js/Coulson/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/Coulson/login.js"></script>
    <script type="text/javascript" src="<%=path%>/js/Coulson/pickout.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=fs7e5ypI0ghzGLY03EHCHoaGIopqxpOb"></script>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:url var="base" value="../../jsp/Coulson/"/>

    <script>
        //初始化页面时执行
        function loading()
        {
            var storage = window.localStorage;
            var $email_input_login = $('#login-phoneno');
            var $email_input_signup = $('#signup-phoneno');

            $email_input_login.val(storage.getItem("email"));
            $email_input_signup.val(storage.getItem("email"));

//            user_position();
        }
        //点击登陆按钮后执行
        function remember1()
        {
            var $email_input_login = $('#login-phoneno').val();
            var storage = window.localStorage;

            storage.setItem("email", $email_input_login);
        }
        //点击注册按钮后执行
        function remember2()
        {
            var $email_input_signup = $('#signup-phoneno').val();
            var storage = window.localStorage;

            storage.setItem("email", $email_input_signup);
        }
    </script>
</head>
<body id="top" onload="loading()">
<%--<div class="home-image" style="height:420px; width:100%; background-image:url(/image/HomePage/1.jpg);">--%>
<%--</div>--%>


<header id="home">
    <nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
                    <nav class="pull">
                        <ul class="top-nav">
                            <li><a href="#intro">Introduction <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                            <li><a href="#features">Features <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                            <li><a href="#responsive">Responsive Design <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                            <li><a href="#portfolio">Portfolio <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                            <li><a href="#team">Team <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                            <li><a href="#contact">Get in Touch <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </nav>
    <section class="hero" id="hero">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-right navicon">
                    <a id="nav-toggle" class="nav_slide_button" href="#"><span></span></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center inner">
                    <h1 class="animated fadeInDown">TRAVEL<span>AROUND</span></h1>
                    <p class="animated fadeInUp delay-05s">An exclusive website for <em>Traveling</em></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center">
                    <a href="javascript:" class="learn-more-btn">Start journey</a>
                    <input type="button" class="login-open" value="<c:out value='${login_name}'/>" onclick="window.open('/UserCenter.htm')"/>
                    <div class="logout">
                        <a onclick="logout()">Log out</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="form-group">
        <%--<label for="city">城市:</label>--%>
        <select name="city" id="city" class="city pickout" placeholder="CHOOSE YOUR CITY">
            <option id="user_location" value="userLoc">${city}</option>
            <c:forEach items="${cityList}" var="city">
                <option value="${city.cityId}">${city.cName}</option>
            </c:forEach>
            <%--<option value="sh">Shanghai</option>--%>
            <%--<option value="qd">Qingdao</option>--%>
            <%--<option value="hz">Hangzhou</option>--%>
        </select>
    </div>

    <div class="login-container">
        <ul class="login-switcher">
            <li class="login-li">
                <a class="login-a" href="#">Log In</a>
            </li>
            <li class="signup-li">
                <a class="signup-a" href="#">Sign Up</a>
            </li>
        </ul>

        <!-- 登录表单 -->
        <div id="login">
            <form method="post" action="/login.htm">
                <div>
                    <label class="login-phoneno-label"
                                   for="login-phoneno">E-mail</label>
                    <input name="email" class="login-phoneno-input" id="login-phoneno" autofocus>
                        <%--<f:ajax render="login-message1" event="keyup"/>--%>
                    </input>
                    <%--<h:message id="login-message1" for="login-phoneno"--%>
                               <%--styleClass="login-phoneno-message"/>--%>
                </div>
                <br/>

                <div>
                    <label class="login-password-label"
                                   for="login-password">Password</label>
                    <input name="uPass" type="password" class="login-password-input" id="login-password"/>
                    <%--<h:message id="login-message2" for="login-password"/>--%>
                </div>
                <br/>

                <div>
                    <%--<input type="checkbox" class="login-remember-checkbox" id="login-remember">--%>
                        <%--&lt;%&ndash;<f:ajax execute="login-remember" render="login_remember_text" event="change"/>&ndash;%&gt;--%>
                    <%--</input>--%>
                    <%--<label class="login-remember-label"--%>
                                   <%--for="login-remember">Remember me</label>--%>
                    <input type="submit" id="login-button" class="button-login" value="LOG IN" onclick="remember1()"/>
                </div>
                <br/>

            </form>
            <%--<input type="hidden" id="login_error" value="#{login_Signup.error1}"/>--%>
            <input type="hidden" id="login_error" value="<c:out value='${login_error}'/>"/>
            <%--<input type="hidden" id="login_remember_text" value="#{login_Signup.remember}"/>--%>
            <input type="hidden" id="login_success" value="<c:out value='${login_success}'/>"/>
        </div>

        <!-- 注册表单 -->
        <div id="signup">
            <form method="post" action="/signup.htm">
                <%--<h:message for="signup-phoneno" id="signup-message-phoneno"--%>
                           <%--styleClass="signup-phoneno-message"/>--%>
                <%--<h:message for="signup-email" id="signup-message-email"--%>
                           <%--styleClass="signup-email-message"/>--%>
                <%--<h:panelGrid columns="2" cellspacing="30px" styleClass="signup-form">--%>

                    <div>
                        <label class="signup-phoneno-label" for="signup-phoneno">E-mail</label>
                        <input name="email" class="signup-phoneno-input" id="signup-phoneno" autofocus>
                        <%--<!--<f:ajax event="keyup" render="signup-message-phoneno"/>-->--%>
                        </input>
                    </div>
                    <div>
                        <label class="signup-email-label" for="signup-email">UserName</label>
                        <input name="uName" class="signup-email-input" id="signup-email">
                        <%--<!--<f:ajax event="keyup" render="signup-message-email"/>-->--%>
                        </input>
                    </div>
                    <div>
                        <label class="signup-password-label" for="signup-password">Password</label>
                        <input name="uPass" type="password" class="signup-password-input" id="signup-password"/>
                    </div>



                <%--</h:panelGrid>--%>

                <div class="protocol-div">
                    <%--<input type="checkbox" class="protocol-checkbox" id="user-protocol">--%>
                        <%--&lt;%&ndash;<f:ajax execute="user-protocol" render="signup-button agree-text"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;event="change"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;listener="#{ajaxBean.buttonvalue}"/>&ndash;%&gt;--%>
                    <%--</input>--%>
                    <%--<label class="signup-protocol-label" for="user-protocol">I agree <a--%>
                            <%--href="#"--%>
                            <%--style="color: white">User protocol</a>--%>
                    <%--</label>--%>
                    <input type="submit" id="signup-button" class="button-signup" value="SIGN UP" onclick="remember2()"/>
                    <%--<h:outputText style="display: none" id="agree-text" value="#{ajaxBean.agree}"/>--%>
                </div>
                <br/>
            </form>
            <%--<h:outputText style="display: none" id="agree-text" value="#{ajaxBean.agree}"/>--%>
            <input type="hidden" id="signup_error" value="<c:out value='${signup_error}'/>"/>
            <%--<h:outputText style="display: none" id="signup_null_error"--%>
                          <%--value="#{login_Signup.signup_null_error}"/>--%>
            <input type="hidden" id="signup_success" value="<c:out value='${signup_success}'/>"/>
        </div>

    </div>
    <div class="login-mask"/>
</header>
<section class="intro text-center section-padding" id="intro">
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 wp1">
                <h1 class="arrow">A Creative Portfolio Template</h1>
                <p>Sed a lorem quis neque interdum <a href="#">consequat ut sed sem</a>. Duis quis tempor nunc. Interdum et malesuada fames ac ante ipsum primis in faucibus. Praesent id tempor ipsum. Fusce at massa ac nunc porta fringilla sed eget neque. Quisque quis pretium nulla. Fusce eget bibendum neque, vel volutpat augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Interdum et malesuada fames ac ante ipsum primis in faucibus.</p>
            </div>
        </div>
    </div>
</section>
<section class="features text-center section-padding" id="features">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="arrow">Love what you do, and you'll do it well</h1>
                <div class="features-wrapper">
                    <div class="col-md-4 wp2">
                        <div class="icon">
                            <i class="fa fa-laptop shadow" style="line-height: 3;"></i>
                        </div>
                        <h2>Digital Design</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a lorem quis neque interdum consequat ut sed sem. Duis quis tempor nunc. Interdum et malesuada fames ac ante ipsum
                            primis in faucibus.</p>
                    </div>
                    <div class="col-md-4 wp2 delay-05s">
                        <div class="icon">
                            <i class="fa fa-code shadow" style="line-height: 3;"></i>
                        </div>
                        <h2>Web Development</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a lorem quis neque interdum consequat ut sed sem. Duis quis tempor nunc. Interdum et malesuada fames ac ante ipsum
                            primis in faucibus.</p>
                    </div>
                    <div class="col-md-4 wp2 delay-1s">
                        <div class="icon">
                            <i class="fa fa-heart shadow" style="line-height: 3;"></i>
                        </div>
                        <h2>Creative Direction</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a lorem quis neque interdum consequat ut sed sem. Duis quis tempor nunc. Interdum et malesuada fames ac ante ipsum
                            primis in faucibus.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="text-center" id="responsive">
    <div class="container-fluid nopadding responsive-services">
        <div class="wrapper">
            <div class="iphone">
                <div class="wp3"></div>
            </div>
            <div class="fluid-white"></div>
        </div>
        <div class="container designs">
            <div class="row">
                <div class="col-md-5 col-md-offset-7">
                    <div id="servicesSlider">
                        <ul class="slides">
                            <li>
                                <h1 class="arrow">Responsive Design Specialists</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultricies nulla non metus pulvinar imperdiet. Praesent non adipiscing libero. </p>
                                <p>
                                    Mauris ultrices odio vitae nulla ultrices iaculis. Nulla rhoncus odio eu lectus faucibus facilisis. Maecenas ornare augue vitae sollicitudin accumsan. </p>
                                <p>Etiam eget libero et erat eleifend consectetur a nec lectus. Sed id tellus lorem. Suspendisse sed venenatis odio, quis lobortis eros.</p>
                            </li>
                            <li>
                                <h1 class="arrow">Bootstrap Professionals</h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultricies nulla non metus pulvinar imperdiet. Praesent non adipiscing libero. </p>
                                <p>
                                    Mauris ultrices odio vitae nulla ultrices iaculis. Nulla rhoncus odio eu lectus faucibus facilisis. Maecenas ornare augue vitae sollicitudin accumsan. </p>
                                <p>Etiam eget libero et erat eleifend consectetur a nec lectus. Sed id tellus lorem. Suspendisse sed venenatis odio, quis lobortis eros.</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="swag text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h1>The way you live<span>is <em>the way</em> you live</span></h1>
                <a href="#portfolio" class="down-arrow-btn"><i style="line-height: 2.5;" class="fa fa-chevron-down"></i></a>
            </div>
        </div>
    </div>
</section>
<section class="portfolio text-center section-padding" id="portfolio">
    <div class="container">
        <div class="row">
            <div id="portfolioSlider">
                <ul class="slides">
                    <li>
                        <div class="col-md-4 wp4">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel1_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel1_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel1_title}</h2>
                            <p>${hotel1_description}</p>
                        </div>
                        <div class="col-md-4 wp4 delay-05s">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel2_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel2_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel2_title}</h2>
                            <p>${hotel2_description}</p>
                        </div>
                        <div class="col-md-4 wp4 delay-1s">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel3_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel3_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel3_title}</h2>
                            <p>${hotel3_description}</p>
                        </div>
                    </li>
                    <li>
                        <div class="col-md-4 wp4">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel4_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel4_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel4_title}</h2>
                            <p>${hotel4_description}</p>
                        </div>
                        <div class="col-md-4 wp4 delay-05s">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel5_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel5_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel5_title}</h2>
                            <p>${hotel5_description}</p>
                        </div>
                        <div class="col-md-4 wp4 delay-1s">
                            <div class="overlay-effect effects clearfix">
                                <div class="img">
                                    <img src="${hotel6_picture}" alt="Portfolio Item">
                                    <div class="overlay">
                                        <input type="hidden" value="${hotel6_ID}">
                                        <a href="HotelPage.htm" class="expand" onclick="hotelClicked(this)"><i class="fa fa-search"></i><br>View More</a>
                                        <a class="close-overlay hidden">x</a>
                                    </div>
                                </div>
                            </div>
                            <h2>${hotel6_title}</h2>
                            <p>${hotel6_description}</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>
<div class="ignite-cta text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a href="#" class="ignite-btn">Ignite Your Passion</a>
            </div>
        </div>
    </div>
</div>
<section class="team text-center section-padding" id="team">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="arrow">We're a team that adore what we do</h1>
            </div>
        </div>
        <div class="row">
            <div class="team-wrapper">
                <div id="teamSlider">
                    <ul class="slides">
                        <li>
                            <div class="col-md-4 wp5">
                                <img src="${food1_picture}" alt="Team Member">
                                <h2>${food1_name}</h2>
                                <p>${food1_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food1_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-4 wp5 delay-05s">
                                <img src="${food2_picture}" alt="Team Member">
                                <h2>${food2_name}</h2>
                                <p>${food2_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food2_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 wp5 delay-1s">
                                <img src="${food3_picture}" alt="Team Member">
                                <h2>${food3_name}</h2>
                                <p>${food3_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food3_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="col-md-4 wp5">
                                <img src="${food4_picture}" alt="Team Member">
                                <h2>${food4_name}</h2>
                                <p>${food4_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food4_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 wp5 delay-05s">
                                <img src="${food5_picture}" alt="Team Member">
                                <h2>${food5_name}</h2>
                                <p>${food5_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food5_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i style="content: '\f004'" class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 wp5 delay-1s">
                                <img src="${food6_picture}" alt="Team Member">
                                <h2>${food6_name}</h2>
                                <p>${food6_description}</p>
                                <div class="social">
                                    <ul class="social-buttons">
                                        <li>
                                            <input type="hidden" value="${food6_ID}">
                                            <a href="FoodPage.htm" class="social-btn"><i class="fa fa-twitter"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="subscribe text-center">
    <div class="container">
        <h1><i class="fa fa-paper-plane"></i><span>Subscribe to stay in the loop</span></h1>
        <form action="#">
            <input type="text" name="" value="" placeholder="" required>
            <input type="submit" name="" value="Send">
        </form>
    </div>
</section>
<section class="dark-bg text-center section-padding contact-wrap" id="contact">
    <a href="#top" class="up-btn"><i style="line-height: 2.8;" class="fa fa-chevron-up"></i></a>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="arrow">Drop us a line</h1>
            </div>
        </div>
        <div class="row contact-details">
            <div class="col-md-4">
                <div class="light-box box-hover">
                    <h2><i class="fa fa-map-marker"></i><span>Address</span></h2>
                    <p>Level 6, 23 Pitt St, Sydney</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="light-box box-hover">
                    <h2><i class="fa fa-mobile"></i><span>Phone</span></h2>
                    <p>+61 9 211 3747</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="light-box box-hover">
                    <h2><i class="fa fa-paper-plane"></i><span>Email</span></h2>
                    <p><a href="#">hey@halcyondays.com</a></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <ul class="social-buttons">
                    <li><a href="#" class="social-btn"><i class="fa fa-dribbble"></i></a></li>
                    <li><a href="#" class="social-btn"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#" class="social-btn"><i class="fa fa-envelope"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</section>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <ul class="legals">
                    <li><a href="#">Terms &amp; Conditions</a></li>
                    <li><a href="#">Legals</a></li>
                </ul>
            </div>
            <div class="col-md-6 credit">
                <p>A free website template created exclusively for <a href="http://tympanus.net/codrops/"><em>Codrops</em></a></p>
            </div>
        </div>
    </div>
</footer>

<script>
    pickout.to({
        el:'.city',
        theme: 'dark',
        search: true
    });

    pickout.updated('.city');

    //浏览器定位
    function user_position(){
        if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition(function(position){
                var longitude = position.coords.longitude;
                var latitude = position.coords.latitude;
                console.log(longitude);
                console.log(latitude);
                var gc = new BMap.Geocoder();

                var pointAdd = new BMap.Point(longitude, latitude);
                gc.getLocation(pointAdd, function(rs){
                    var city = rs.addressComponents.city;
                    console.log(city);

                    var $location = $('.pk-option').children('span').eq(0);
                    $location.html(city + "           (current position)");
                });
            });
        }
    }

    //跳转到预订酒店界面
    function hotelClicked(e){
        var params = {};
        //params.XX必须与Spring Mvc controller中的参数名称一致
        //否则在controller中使用@RequestParam绑定
        params.hotelID = $(e).prev().val();
//        alert(params.hotelID);
        $.ajax({
            async:false,
            type: "POST",
            url: "HotelPage.htm",//注意路径
            data:params,
            dataType:"json",
            success:function(data){
                console.log("success");
            },
            error:function(data){
                console.log("error");
            }
        });
    }

    //用户登出
    function logout(){
        var xmlhttp;
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
            {
                window.location.href='/HomePage.htm';
            }
        }
        xmlhttp.open("GET", "/logout.htm", true);
        xmlhttp.send();
    }
</script>
<script src="<%=path%>/js/Coulson/waypoints.min.js"></script>
<script src="<%=path%>/js/Coulson/bootstrap.min.js"></script>
<script src="<%=path%>/js/Coulson/scripts.js"></script>
<script src="<%=path%>/js/Coulson/jquery.flexslider.js"></script>
<script src="<%=path%>/js/Coulson/modernizr.js"></script>
</body>
</html>
