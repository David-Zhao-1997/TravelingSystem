package controller;

import beans.City;
import beans.Hotel;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CityDaoService;
import service.HotelDaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "HotelPage.htm")
public class HotelPageController {

    @Autowired
    private HotelDaoService hotelDaoService;

    @Autowired
    private CityDaoService cityDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model, HttpServletRequest request) {
        List<City> cityList = cityDaoService.getCityListOrderedByViewCount();
        model.addAttribute("cityList", cityList);

        //获取之前存储在session中的hotelID【edited by Coulson】
        HttpSession session = request.getSession();
        String hotelID = (String) session.getAttribute("hotelID");
        //若hotelID存在【edited by Coulson】
        if (hotelID != null) {
            Hotel hotel = hotelDaoService.getHotelByID(Integer.parseInt(hotelID));
            List<Hotel> hotelList = new ArrayList<>();
            hotelList.add(hotel);
            model.addAttribute("hotelList", hotelList);
        }
//        User loginName = (User) session.getAttribute("user");
//        model.addAttribute("login_Name",loginName);
//        System.out.println(loginName);
        return "Nick/HotelPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(String hotelID, String cityId, ModelMap model, HttpServletRequest request) {
        //如果有从HomePage发送请求预定酒店，则存储请求的hotelID【edited by Coulson】
        if (hotelID != null) {
            Hotel hotel = hotelDaoService.getHotelByID(Integer.parseInt(hotelID));
            //酒店viewCount加一
            hotelDaoService.increaseViewCount(hotel.getHotelId());
            //酒店所在城市viewCount加一
            cityDaoService.increaseViewCount(hotel.getCityId());
            HttpSession session = request.getSession();
            session.setAttribute("hotelID", hotelID);
            System.out.println("HotelID:" + hotelID);
        } else {
            System.out.println("未收取到HomePage页发来的请求");
            List<Hotel> hotelList = hotelDaoService.getHotelByCityID(Integer.parseInt(cityId));
            model.addAttribute("hotelList", hotelList);
            List<City> cityList = cityDaoService.getCityListOrderedByViewCount();
            model.addAttribute("cityList", cityList);
        }
        return "Nick/HotelPage";
    }
}

