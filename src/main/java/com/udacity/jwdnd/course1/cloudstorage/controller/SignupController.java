package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup(@ModelAttribute("user") User user, Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        String createUserError = null;

        if (userService.isUsernameExist(user.getUsername())) {
            createUserError = "The username already exists.";
        }

        if (createUserError == null) {
            int userAdded = userService.addUser(user);
            if (userAdded < 0) {
                createUserError = "There was an error signing you up. Please try again.";
            }
        }

        if (createUserError == null) {
            model.addAttribute("signupSuccess", true);
            return "redirect:/login?success=true";
        } else {
            model.addAttribute("signupError", createUserError);
        }

        return "signup";
    }
}
