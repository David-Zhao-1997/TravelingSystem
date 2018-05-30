package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import beans.User;
import service.UserDaoService;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 23:00 2018/5/10
 * @Modified By:
 */
@Controller
public class HomePageController
{

    @Autowired
    private UserDaoService userDaoService;

    /**
     * @Description: 跳转到主页
     * @Date: 17:53 2018/5/29
     * @Param: [model]
     * @return: java.lang.String
     **/
    @RequestMapping("/HomePage.htm")
    public String showView(ModelMap model)
    {
        return "Coulson/HomePage";
    }

    /**
     * @Description: 用户登录表单
     * @Date: 18:07 2018/5/29
     * @Param: [login_email, login_pass, model, request]
     * @return: java.lang.String
     **/
    @RequestMapping("/login.htm")
    public String loginForm(User user, ModelMap model, HttpServletRequest request)
    {
        System.out.println(user.getEmail() + user.getuPass());
        User user1 = userDaoService.validateUser(user.getEmail(), user.getuPass());
        if (user1 == null)
        {
            System.out.println("Login fail");
        }
        else
        {
            System.out.println("Login success");
        }
        return "Coulson/HomePage";
    }

    /**
     * @Description: 用户注册表单
     * @Date: 18:09 2018/5/29
     * @Param: []
     * @return: java.lang.String
     **/
    @RequestMapping("/signup.htm")
    public String signupForm(User user, ModelMap model, HttpServletRequest request)
    {
        System.out.println(user.getEmail() + user.getuName() + user.getuPass());
        boolean flag = userDaoService.isUserExist(user.getEmail());
        if (flag)
        {
            System.out.println("The E-mail address has been registered.");
        }
        else
        {
            userDaoService.saveUser(user);
            System.out.println("Sign up success.");
        }
        return "Coulson/HomePage";
    }
}

