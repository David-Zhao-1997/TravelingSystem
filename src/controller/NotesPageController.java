package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.HotelDaoService;
import service.UserDaoService;

@Controller
@RequestMapping(value = "NotesPage.htm")
public class NotesPageController
{

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showView(ModelMap model)
    {
        return "Frank/NotesPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm()
    {
        return "index";
    }
}
