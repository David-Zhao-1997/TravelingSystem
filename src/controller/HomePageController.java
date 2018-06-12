package controller;

import beans.Food;
import beans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.City;
import beans.Hotel;
import service.CityDaoService;
import service.FoodDaoService;
import service.HotelDaoService;
import service.UserDaoService;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 23:00 2018/5/10
 * @Modified By:
 */
@Controller
public class HomePageController
{
    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private CityDaoService cityDaoService;
    @Autowired
    private HotelDaoService hotelDaoService;
    @Autowired
    private FoodDaoService foodDaoService;

    /**
     * @Description: 更改登录注册状态
     * @Date: 10:45 2018/5/30
     * @Param: [login_error, login_success, signup_error, signup_success, model]
     * @return: void
     **/
    static void changeLoginState(String login_error, String login_success, String signup_error, String signup_success, ModelMap model)
    {
        model.addAttribute("login_error", login_error);
        model.addAttribute("login_success", login_success);
        model.addAttribute("signup_error", signup_error);
        model.addAttribute("signup_success", signup_success);
    }

    /**
    * @Description: 更改各模块信息
    * @Date: 21:58 2018/6/5
    * @Param: [hotelList, model]
    * @return: void
    **/
    static void changeInfo(List<Hotel> hotelList, List<Food> foodList, ModelMap model){
        for(int i=0; i<6; i++){
            model.addAttribute("hotel"+(i+1)+"_ID", hotelList.get(i).getHotelId());
            model.addAttribute("hotel"+(i+1)+"_title", hotelList.get(i).gethName());
            model.addAttribute("hotel"+(i+1)+"_picture", hotelList.get(i).getPictures());
            model.addAttribute("hotel"+(i+1)+"_description", hotelList.get(i).getDescription());

            model.addAttribute("food"+(i+1)+"_ID", foodList.get(i).getFoodId());
            model.addAttribute("food"+(i+1)+"_name", foodList.get(i).getfName());
            model.addAttribute("food"+(i+1)+"_picture", foodList.get(i).getPictures());
            model.addAttribute("food"+(i+1)+"_description", foodList.get(i).getDescription());
        }
    }

    /**
     * @Description: 跳转到主页
     * @Date: 17:53 2018/5/29
     * @Param: [model]
     * @return: java.lang.String
     **/
    @RequestMapping("/HomePage.htm")
    public String showView(ModelMap model, HttpServletRequest request)
    {
        //获取session
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3 * 60);
        //初始化城市选择框
        model.addAttribute("city", "Your City");

        //判断用户是否登陆
        if(session.getAttribute("user") == null){
            //初始化登录注册状态
            changeLoginState("false", "false", "false", "false", model);
        }else {
            //获取已登陆用户信息
            changeLoginState("false", "true", "false", "false", model);
            Users userLogined = (Users) session.getAttribute("user");
            model.addAttribute("login_name", userLogined.getuName());
            System.out.println(userLogined.getuName());
        }

        //从数据库获取城市列表
        List<City> cityList= cityDaoService.getCityListByName("");
        model.addAttribute("cityList", cityList);

        //若未选任何城市，获取各模块信息
        List<Hotel> hotelList = hotelDaoService.getHotelListOrderedByViewCount();
        List<Food> foodList = foodDaoService.getFoodListOrderedByViewCount();
        changeInfo(hotelList, foodList, model);
        //若已选择城市
        if(session.getAttribute("city") != null){
            //更改城市选择框值
            model.addAttribute("city", session.getAttribute("city"));
            //查询所选城市ID
            List<City> selectedCity = cityDaoService.getCityListByName((String) session.getAttribute("city"));
            int cityID = selectedCity.get(0).getCityId();
            //查询所选城市酒店信息
            List<Hotel> selectedHotel = hotelDaoService.getHotelListByCityOrderedByViewCount(cityID);
            //查询所选城市美食信息
            List<Food> selectedFood = foodDaoService.getFoodListByCityOrderedByViewCount(cityID);
            changeInfo(selectedHotel, selectedFood, model);
        }

        return "Coulson/HomePage";
    }

    /**
     * @Description: 用户登录表单
     * @Date: 18:07 2018/5/29
     * @Param: [login_email, login_pass, model, request]
     * @return: java.lang.String
     **/
    @RequestMapping("/login.htm")
    public String loginForm(Users user, ModelMap model, HttpServletRequest request)
    {
        System.out.println(user.getEmail() + user.getuPass());
        HttpSession session = request.getSession();

        //登陆验证
        Users userLogined = userDaoService.validateUser(user.getEmail(), user.getuPass());
        //若登陆失败
        if (userLogined == null)
        {
            changeLoginState("true", "false", "false", "false", model);
            System.out.println("Login fail");
        }
        //若登陆成功
        else
        {
            changeLoginState("false", "true", "false", "false", model);
            session.setAttribute("user", userLogined);
            model.addAttribute("login_name", userLogined.getuName());
            System.out.println("Login success");
            //若已选择城市
            if(session.getAttribute("city") != null) {
                model.addAttribute("city", session.getAttribute("city"));
            }
            //若未选城市
            else{
                model.addAttribute("city", "Your City");
            }
        }

        //向城市选择框添加所有城市
        List<City> cityList= cityDaoService.getCityListByName("");
        model.addAttribute("cityList", cityList);
        //若已选择城市，更改hotel和food模块
        if(session.getAttribute("city") != null) {
            //查询所选城市ID
            List<City> selectedCity = cityDaoService.getCityListByName((String) session.getAttribute("city"));
            int cityID = selectedCity.get(0).getCityId();
            //查询所选城市酒店信息
            List<Hotel> selectedHotel = hotelDaoService.getHotelListByCityOrderedByViewCount(cityID);
            //查询所选城市美食信息
            List<Food> selectedFood = foodDaoService.getFoodListByCityOrderedByViewCount(cityID);
            changeInfo(selectedHotel, selectedFood, model);
        }
        //若未选城市，恢复hotel和food模块默认设置
        else{
            List<Hotel> hotelList = hotelDaoService.getHotelListOrderedByViewCount();
            List<Food> foodList = foodDaoService.getFoodListOrderedByViewCount();
            changeInfo(hotelList, foodList, model);
        }
        return "Coulson/HomePage";
    }

    /**
     * @Description: 用户注册表单
     * @Date: 18:09 2018/5/29
     * @Param: []
     * @return: java.lang.String
     **/
    @RequestMapping("/signup.htm")
    public String signupForm(Users user, ModelMap model, HttpServletRequest request)
    {
        System.out.println(user.getEmail() + user.getuName() + user.getuPass());

        //若有输入值为空
        boolean nullError = false;
        if (user.getEmail().equals("") || user.getuName().equals("") || user.getuPass().equals(""))
        {
            nullError = true;
        }

        boolean flag = userDaoService.isUserExist(user.getEmail());
        //若注册失败
        if (flag || nullError)
        {
            changeLoginState("false", "false", "true", "false", model);
            System.out.println("The E-mail address has been registered.");
        }
        //若注册成功
        else
        {
            userDaoService.saveUser(user);
            changeLoginState("false", "false", "false", "true", model);
            System.out.println("Sign up success.");
        }
        return "Coulson/HomePage";
    }

    /**
     * @Description: 接收ajax传递过来的用户选择的城市
     * @Date: 16:43 2018/5/31
     * @Param: []
     * @return: java.lang.String
     **/
    @RequestMapping("/city.htm")
    @ResponseBody
    public String changeCity(String city, HttpServletRequest request, ModelMap model)
    {
        if (city.equals("青岛市           (current position)"))
        {
            city = "Qingdao";
        }
        String json = "{\"city\":\"" + city + "\"}";
        System.out.println(city);
        HttpSession session = request.getSession();
        session.setAttribute("city", city);

        return json;
    }
}