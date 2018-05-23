package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 23:00 2018/5/10
 * @Modified By:
 */
@Controller
@RequestMapping(value = "HomePage.htm")
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model){
        return "Coulson/HomePage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(){
        return "index";
    }
}
