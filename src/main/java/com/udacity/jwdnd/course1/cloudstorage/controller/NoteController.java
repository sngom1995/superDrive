package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.domain.Note;
import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import com.udacity.jwdnd.course1.cloudstorage.services.INoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {
    private final INoteService noteService;
    private final UserService userService;

    public NoteController(INoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping("/notes")
    public String addNote(@ModelAttribute("note") Note note, Model model, Authentication authentication) {
        User user = userService.getUserByUsername(authentication.getName());
        if (note.getNoteId() != null){
            noteService.updateNote(note);
        }
        else {
            note.setUserId(user.getUserId());
            noteService.addNote(note);
        }
        return "redirect:/home";

    }

    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable Integer id, Model model) {
        noteService.deleteNote(id);
        return "redirect:/home";
    }
}
