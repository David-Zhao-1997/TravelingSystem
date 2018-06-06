package controller;

import beans.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.FoodDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "FoodPage.htm")
public class FoodPageController
{
    @Autowired
    private FoodDaoService foodDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model,HttpServletRequest request)
    {
        return "Nick/FoodPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(String fName,ModelMap model,HttpServletRequest request)
    {
        List<Food> foodList = foodDaoService.getFoodListByName(fName);
        model.addAttribute("foodList",foodList);
        return "Nick/FoodPage";
    }
}


