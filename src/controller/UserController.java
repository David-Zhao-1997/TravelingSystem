package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserDaoService;
import util.ApplicationContextUtil;

@Controller
public class UserController
{
    private UserDaoService userDaoService;

    public UserController()
    {
        userDaoService = (UserDaoService) ApplicationContextUtil.applicationContext.getBean("UserDaoService");
    }

    public static void main(String[] args)
    {
        UserController userController = new UserController();
        userController.userDaoService.test();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String showView()
    {
        return "login";
    }
}
