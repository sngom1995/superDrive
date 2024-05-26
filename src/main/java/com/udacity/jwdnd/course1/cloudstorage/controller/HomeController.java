package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.domain.Note;
import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final UserService userService;
    private final NoteService noteService;
    private final FileService fileService;


    public HomeController(UserService userService, NoteService noteService, FileService fileService) {
        this.userService = userService;
        this.noteService = noteService;
        this.fileService = fileService;
    }

    @GetMapping("/home")
    public String home(@ModelAttribute("note") Note note,  Model model, Authentication authentication) {
        User user = userService.getUserByUsername(authentication.getName());
        System.out.println("files:"+fileService.getAllFilesByUserId(user.getUserId()));
        model.addAttribute("notes", noteService.getAllNotesByUserId(user.getUserId()));
        model.addAttribute("files", fileService.getAllFilesByUserId(user.getUserId()));
        return "home";
    }
}
