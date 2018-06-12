package controller;

import beans.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RequestMapping(value = "index.htm")
@Controller
public class IndexController
{
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showView()
    {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String processRequest(Users user, Model model)
    {
        System.out.println(user);
        model.addAttribute("user", user);
        return "show";
    }
}
