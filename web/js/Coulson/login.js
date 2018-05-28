jQuery(document).ready(function(){
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