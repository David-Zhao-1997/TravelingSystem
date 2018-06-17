package controller;

import beans.Hotel;
import beans.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.HotelDaoService;
import service.NoteDaoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UpdateController {

    @Autowired
    private NoteDaoService noteDaoService;

    @RequestMapping(value = "Update.htm", method = RequestMethod.GET)
    public String showView(Note note, ModelMap model) {
        Note newNote = noteDaoService.getNoteByID(note.getNoteId());
        model.addAttribute("note", newNote);
        System.out.println("newNote:" + newNote);
        return "Frank/Update";
    }

    @RequestMapping(value = "UpdateNote.htm", method = RequestMethod.POST)
    public void processForm(ModelMap model, Note note, HttpServletResponse response) {
        Note newNote = noteDaoService.getNoteByID(note.getNoteId());
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        newNote.setCityId(note.getCityId());
        newNote.setEmail(note.getEmail());
        newNote.setPictures("image/Frank/qing.jpg");
        noteDaoService.updateNote(newNote);
        try {
            response.sendRedirect("/NotesPage.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "DeleteNote.htm", method = RequestMethod.GET)
    public void processDeleteForm(ModelMap model, Note note, HttpServletResponse response) {
        Note newNote = noteDaoService.getNoteByID(note.getNoteId());
        noteDaoService.deleteNote(newNote);
        try {
            response.sendRedirect("/NotesPage.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}