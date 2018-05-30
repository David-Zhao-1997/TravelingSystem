package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserDaoService;

@Controller
public class UserController
{
    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String showView()
    {
        userDaoService.test();
        return "login";
    }
}
