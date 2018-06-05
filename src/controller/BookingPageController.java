package controller;

import beans.City;
import beans.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityDaoService;
import service.HotelDaoService;

import java.util.List;

@Controller
@RequestMapping(value = "BookingPage.htm")
public class BookingPageController
{

    @Autowired
    private HotelDaoService hotelDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(String bookHotelID,ModelMap model)
    {
        Hotel hotel = hotelDaoService.getHotelByID(Integer.parseInt(bookHotelID));
        model.addAttribute("hotel",hotel);
        return "Nick/BookingPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(String cityId, ModelMap model)
    {
        return "Nick/HotelPage";
    }
}

