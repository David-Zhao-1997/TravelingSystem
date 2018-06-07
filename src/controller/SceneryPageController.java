package controller;

import beans.City;
import beans.Resort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityDaoService;
import service.HotelDaoService;
import service.ResortDaoService;

import java.util.List;

@Controller
@RequestMapping(value = "SceneryPage.htm")
public class SceneryPageController
{

    @Autowired
    private ResortDaoService resortDaoService;

    @Autowired
    private CityDaoService cityDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model)
    {
        List<City> cityList = cityDaoService.getCityListOrderedByViewCount();
        model.addAttribute("cityList", cityList);
        return "Frank/SceneryPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(ModelMap modelMap,String cName,String cityId)
    {
        System.out.println(cName);
//        City city = cityDaoService.getCityListByName(cName).get(0);
//        modelMap.addAttribute("city",city);
        List<City> cityList = cityDaoService.getCityListByName(cName);
        for(int i=0;i<cityList.size();i++){
            City city = cityList.get(i);
            List<Resort> resortList = resortDaoService.getResortByCityID(city.getCityId());
            modelMap.addAttribute("resortList",resortList);
        }
        modelMap.addAttribute("cityList",cityList);

        return "Frank/CityDetailPage";
    }
}