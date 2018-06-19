package controller;

import beans.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.NoteDaoService;
import service.UserDaoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Controller
public class NotesController {

    @Autowired
    private NoteDaoService noteDaoService;

    @RequestMapping(value = "Notes.htm", method = RequestMethod.GET)
    public String showView() {
        return "/Frank/Notes";
    }

    @RequestMapping(value = "NotesPage.htm", method = RequestMethod.POST)
    public void addNotes(String content, int CityId, String title, String email, HttpServletResponse response) {
        Note note = new Note();
        note.setCityId(CityId);
        note.setTitle(title);
        note.setContent(content);
        note.setDown(0);
        note.setUp(0);
        note.setPictures("image/Frank/qing.jpg");
        note.setEditTime(new Timestamp(new Date().getTime()));
        note.setEmail(email);
        note.setState(0);
        noteDaoService.saveNote(note);
        try {
            response.sendRedirect("/NotesPage.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "Frank/NotesPage";
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String UpdateNote(String content, int CityId, String title, String email) {
//        Note note = new Note();
//        note.setCityId(CityId);
//        note.setTitle(title);
//        note.setContent(content);
//        note.setDown(0);
//        note.setUp(0);
//        note.setEditTime(new Timestamp(new Date().getTime()));
//        note.setEmail(email);
//        note.setState(0);
//        noteDaoService.updateNote(note);
//        return "Frank/Notes";
//    }
//

}