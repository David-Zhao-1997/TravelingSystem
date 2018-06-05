package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.HotelDaoService;

@Controller
@RequestMapping(value = "SceneryPage.htm")
public class SceneryPageController
{

    @Autowired
    private HotelDaoService hotelDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model)
    {
        return "Frank/SceneryPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm()
    {
        return "index";
    }
}