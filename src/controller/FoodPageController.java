package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.FoodDaoService;

@Controller
@RequestMapping(value = "FoodPage.htm")
public class FoodPageController
{
    @Autowired
    private FoodDaoService foodDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model)
    {
        return "Nick/FoodPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm()
    {
        return "index";
    }
}


