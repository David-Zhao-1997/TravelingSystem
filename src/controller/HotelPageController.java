package controller;

import beans.City;
import beans.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CityDaoService;
import service.HotelDaoService;

import java.util.List;

@Controller
@RequestMapping(value = "HotelPage.htm")
public class HotelPageController
{

    @Autowired
    private HotelDaoService hotelDaoService;

    @Autowired
    private CityDaoService cityDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model)
    {
        List<City> cityList = cityDaoService.getCityListOrderedByViewCount();
        model.addAttribute("cityList",cityList);
        return "Nick/HotelPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(String cityId, ModelMap model)
    {
//        City city = cityDaoService.getCityByID(Integer.parseInt(cityId));
        List<Hotel> hotelList = hotelDaoService.getHotelByCityID(Integer.parseInt(cityId));
        model.addAttribute("hotelList",hotelList);
        List<City> cityList = cityDaoService.getCityListOrderedByViewCount();
        model.addAttribute("cityList",cityList);
        return "Nick/HotelPage";
    }
}

