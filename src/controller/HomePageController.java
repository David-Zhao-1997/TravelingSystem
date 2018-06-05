package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * @Description: 初始化登录注册状态
     * @Date: 10:45 2018/5/30
     * @Param: [login_error, login_success, signup_error, signup_success, model]
     * @return: void
     **/
    private static void initialState(String login_error, String login_success, String signup_error, String signup_success, ModelMap model)
    {
        model.addAttribute("login_error", login_error);
        model.addAttribute("login_success", login_success);
        model.addAttribute("signup_error", signup_error);
        model.addAttribute("signup_success", signup_success);
    }

    /**
     * @Description: 跳转到主页
     * @Date: 17:53 2018/5/29
     * @Param: [model]
     * @return: java.lang.String
     **/
    @RequestMapping("/HomePage.htm")
    public String showView(ModelMap model)
    {
        //初始化登录注册状态
        initialState("false", "false", "false", "false", model);
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

        User userLogined = userDaoService.validateUser(user.getEmail(), user.getuPass());
        //若登陆失败
        if (userLogined == null)
        {
            initialState("true", "false", "false", "false", model);
            System.out.println("Login fail");
        }
        //若登陆成功
        else
        {
            initialState("false", "true", "false", "false", model);
            HttpSession session = request.getSession();
            session.setAttribute("user", userLogined);
            model.addAttribute("login_name", userLogined.getuName());
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

        //若有输入值为空
        boolean nullError = false;
        if (user.getEmail() == "" || user.getuName() == "" || user.getuPass() == "")
        {
            nullError = true;
        }

        boolean flag = userDaoService.isUserExist(user.getEmail());
        //若注册失败
        if (flag || nullError)
        {
            initialState("false", "false", "true", "false", model);
            System.out.println("The E-mail address has been registered.");
        }
        //若注册成功
        else
        {
            userDaoService.saveUser(user);
            initialState("false", "false", "false", "true", model);
            System.out.println("Sign up success.");
        }
        return "Coulson/HomePage";
    }

    /**
     * @Description: 接收ajax传递过来的用户选择的城市
     * @Date: 16:43 2018/5/31
     * @Param: []
     * @return: java.lang.String
     **/
    @RequestMapping("/city.htm")
    @ResponseBody
    public String changeCity(String city)
    {
        if (city.equals("青岛市"))
        {
            city = "Qingdao";
        }
        String json = "{\"city\":\"" + city + "\"}";
        System.out.println(city);
        return json;
    }
}

