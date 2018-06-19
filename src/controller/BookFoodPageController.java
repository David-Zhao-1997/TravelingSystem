package controller;

import beans.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.FoodDaoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="BookFoodPage.htm")
public class BookFoodPageController {
    @Autowired
    private FoodDaoService foodDaoService;
    @RequestMapping(method = RequestMethod.GET)
    public String showView( ModelMap modelMap){
        Food food = foodDaoService.getFoodByID(2);
        modelMap.addAttribute("food",food);
        return "Nick/BookFoodPage";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String proccessForm(String foodID,ModelMap modelMap){
        return "Nick/FoodPage";
    }
}
