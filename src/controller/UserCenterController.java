package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 14:21 2018/6/7
 * @Modified By:
 */
@Controller
public class UserCenterController {
    @RequestMapping("/UserCenter.htm")
    public String showView(){
        return "Coulson/UserCenter";
    }
}
