package controller;

import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.CityDaoService;
import service.FoodDaoService;
import service.HotelDaoService;
import service.UserDaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 14:21 2018/6/7
 * @Modified By:
 */
@Controller
public class UserCenterController {
    @Autowired
    UserDaoService userDaoService;
    @Autowired
    CityDaoService cityDaoService;
    @Autowired
    FoodDaoService foodDaoService;
    @Autowired
    HotelDaoService hotelDaoService;

    @RequestMapping("/UserCenter.htm")
    public String showView(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User userLogined = (User) session.getAttribute("user");
        //若用户session未过期
        if (null != userLogined) {
            model.addAttribute("user_profile", userLogined.getProfile());
            model.addAttribute("login_name", userLogined.getuName());
        }
        //若用户session过期
        else {
            //页面提示登陆过期，跳转到主页
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
            sb.append("alert(\"Login expired, please login again\");");
            sb.append("window.location.href='/HomePage.htm';");
            sb.append("</script>");
            out.print(sb.toString());
            out.close();
        }
        return "Coulson/UserCenter";
    }

    @RequestMapping("/fileUpload.htm")
    public String receiveFile(@RequestParam("file") CommonsMultipartFile srcFile, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取已登陆用户
        HttpSession session = request.getSession();
        User userLogined = (User) session.getAttribute("user");
        String rootPath = "C:\\Users\\Administrator\\Workspaces\\IDEA\\TravelingSystem\\out\\artifacts\\TravelingSystem_war_exploded\\image\\User\\";

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //如果登陆已过期
        if(null == userLogined){
            StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
            sb.append("window.location.href='/UserCenter.htm';");
            sb.append("</script>");
            out.print(sb.toString());
            out.close();
        }
        //如果登陆没过期
        else {
            //若上传的文件为空
            if(srcFile.getOriginalFilename().equals("")){
                StringBuffer sb2 = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
                sb2.append("alert(\"Invalid uploading, please select one file to upload\");");
                sb2.append("window.location.href='/UserCenter.htm';");
                sb2.append("</script>");
                out.print(sb2.toString());
                out.close();
            }
            //若上传的文件不为空
            else {
                //在存储新图片前，判断用户是否上传过头像，若有则删除旧头像
                if (!userLogined.getProfile().substring(12).equals("defaultProfile.jpg")) {
                    File oldProfile = new File(rootPath.substring(0, 98) + userLogined.getProfile());
                    oldProfile.delete();
                }
                System.out.println("NewProfile Name: " + srcFile.getOriginalFilename());
                //新建目标目录
                String path = rootPath + new Date().getTime() + srcFile.getOriginalFilename();
                File desFile = new File(path);
                System.out.println(path);
                //将上传文件复制到目标目录
                srcFile.transferTo(desFile);

                //存储图片路径到用户表中
                String profile_path = "/image/User/" + path.substring(109);
                userLogined.setProfile(profile_path);
                userDaoService.updateUser(userLogined);

                //往前端添加图片路径
                model.addAttribute("user_profile", profile_path);
                //添加用户姓名
                model.addAttribute("login_name", userLogined.getuName());
            }
        }
        return "Coulson/UserCenter";
    }
}
