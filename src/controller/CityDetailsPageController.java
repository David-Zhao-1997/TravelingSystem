package controller;

import beans.City;
import beans.Resort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityDaoService;
import service.ResortDaoService;
import service.UserDaoService;

import java.util.List;


@Controller
@RequestMapping(value = "CityDetailPage.htm")
public class CityDetailsPageController
{

    @Autowired
    private CityDaoService cityDaoService;
    @Autowired
    private ResortDaoService resortDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView( String cName,ModelMap model)
    {
        City city = cityDaoService.getCityListByName(cName).get(0);
        model.addAttribute("city",city);
        return "Frank/CityDetailPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(String cName, ModelMap model)
    {
        System.out.println(cName);
        int cityID = cityDaoService.getCityListByName(cName).get(0).getCityId();
        List<Resort> list = resortDaoService.getResortListByCityOrderedByViewCount(cityID);
        model.addAttribute("resortList", list);
        return "Frank/CityDetailPage";
    }
}