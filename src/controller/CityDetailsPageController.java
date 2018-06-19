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

        int level = resortDaoService.getResortListByName(cName).get(0).getLevel();
        List<Resort> resortlist = resortDaoService.getResortListOrderedByLevel();
        model.addAttribute("resortList",resortlist);

        return "Frank/CityDetailPage";
    }

    @RequestMapping(value = "/search.htm",method = RequestMethod.POST)
    public String search(String rName, ModelMap model)
    {

        List<Resort> resortlist = resortDaoService.getResortListByName(rName);
        model.addAttribute("resortList",resortlist);

        return "Frank/CityDetailPage";
    }

    @RequestMapping(value="/showbylevel.htm",method = RequestMethod.POST)
    public String showByLevel(ModelMap model)
    {
        List<Resort> resortList = resortDaoService.getResortListOrderedByLevel();
        model.addAttribute("resortList",resortList);
        return "Frank/CityDetailPage";
    }

}