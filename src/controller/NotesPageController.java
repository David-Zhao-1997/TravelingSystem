package controller;

import beans.Note;
import beans.Resort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityDaoService;
import service.HotelDaoService;
import service.NoteDaoService;
import service.UserDaoService;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "NotesPage.htm")
public class NotesPageController {

    @Autowired
    private NoteDaoService noteDaoService;

    @Autowired
    private CityDaoService cityDaoService;


    @RequestMapping(method = RequestMethod.GET)
    public String cancel(HttpSession session, ModelMap model) {
        List<Note> list = noteDaoService.getAllNotes();
        model.addAttribute("NoteList", list);
        return "Frank/NotesPage";
    }


}