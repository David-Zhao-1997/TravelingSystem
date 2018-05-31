jQuery(document).ready(function(){
    //获取登录注册框组件
    var $user_center = $('.login-open');
    var $login_open = $('.learn-more-btn');
    var $login_mask = $('.login-mask');
    var $login_container = $('.login-container');
    var $login_div = $login_container.find('#login');
    var $signup_div = $login_container.find('#signup');
    //获取登录注册框顶部的切换tab组件
    var $switcher = $('.login-switcher');
    var $login_tab = $switcher.children('li').eq(0);
    var $login_a = $login_tab.children('a');
    var $signup_tab = $switcher.children('li').eq(1);
    var $signup_a = $signup_tab.children('a');
    //获取注册表单中input值
    var email_input = document.getElementsByName("email").innerHTML;
    var name_input = document.getElementsByName("uName").innerHTML;
    var pass_input = document.getElementsByName("uPass").innerHTML;
    //获取登陆和注册状态的信息
    var login_error = document.getElementById("login_error").value;
    var signup_error = document.getElementById("signup_error").value;
    var login_success = document.getElementById("login_success").value;
    var signup_success = document.getElementById("signup_success").value;
    console.log(login_error);
    console.log(login_success);
    console.log(signup_error);
    console.log(signup_success);

    //弹出窗口
    $login_open.click(function () {
        $login_mask.fadeIn(400);
        $login_container.slideDown(400);
        $login_div.addClass('is-selected');
        $login_tab.addClass('selected');
        $login_a.addClass('text-selected');
        // login_input.focus();
    });

    //点击非对话框区域关闭弹出窗口
    $login_mask.click(function () {
        $login_mask.fadeOut(100);
        $login_container.slideUp(200);
        // sleep(200);
        $signup_div.removeClass('is-selected');
        $signup_tab.removeClass('selected');
        $signup_a.removeClass('text-selected');
    });

    //使用Esc键关闭弹出窗口
    $(document).keyup(function (event) {
        if (event.which == '27') {
            $login_mask.fadeOut(100);
            $login_container.slideUp(200);
            // sleep(200);
            $signup_div.removeClass('is-selected');
            $signup_tab.removeClass('selected');
            $signup_a.removeClass('text-selected');
        }
    });

    //点击login，切换页面内容
    $login_tab.click(function () {
        login_selected();
    });
    //点击signup，切换页面内容
    $signup_tab.click(function () {
        signup_selected();
    });

    //若登陆失败，显示错误信息，并重新弹出登陆框
    if(login_error !== "false"){
        alert("Login fail");
        $login_mask.fadeIn(700);
        $login_container.fadeIn(1000);
        $login_div.addClass('is-selected');
        $login_tab.addClass('selected');
        $login_a.addClass('text-selected');
    }
    //若登陆成功
    if(login_success !== "false"){
        $user_center.addClass('appear');
        // alert("Login success");
    }

    //若注册输入框有内容为空，显示notnull信息,并重新注册
    // if(email_input === "" || name_input === "" || pass_input === ""){
    //     $signup_div.removeClass('is-selected');
    //     $signup_tab.removeClass('selected');
    //     $signup_a.removeClass('text-selected');
    //     alert("not null");
    //     $login_mask.fadeIn(700);
    //     $login_container.fadeIn(1000);
    //     $signup_div.addClass('is-selected');
    //     $signup_tab.addClass('selected');
    //     $signup_a.addClass('text-selected');
    // }
    //若注册失败，显示错误信息，并重新弹出注册框
    if(signup_error !== "false"){
        $signup_div.removeClass('is-selected');
        $signup_tab.removeClass('selected');
        $signup_a.removeClass('text-selected');
        alert("Sign up fail");
        $login_mask.fadeIn(700);
        $login_container.fadeIn(1000);
        $signup_div.addClass('is-selected');
        $signup_tab.addClass('selected');
        $signup_a.addClass('text-selected');
    }
    //若注册成功，则弹出登陆框
    if(signup_success !== "false")
    {
        alert("Sign up success");
        $login_mask.fadeIn(700);
        $login_container.fadeIn(1000);
        $login_div.addClass('is-selected');
        $login_tab.addClass('selected');
        $login_a.addClass('text-selected');
    }

    function login_selected() {
        $login_div.addClass('is-selected');
        $signup_div.removeClass('is-selected');
        $login_tab.addClass('selected');
        $login_a.addClass('text-selected');
        $signup_tab.removeClass('selected');
        $signup_a.removeClass('text-selected');
    }

    function signup_selected() {
        $login_div.removeClass('is-selected');
        $signup_div.addClass('is-selected');
        $login_tab.removeClass('selected');
        $login_a.removeClass('text-selected');
        $signup_tab.addClass('selected');
        $signup_a.addClass('text-selected');
    }
});