package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.domain.LoginRequest;
import com.udacity.jwdnd.course1.cloudstorage.services.CustomAuthenticationService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserService userService;
    private final CustomAuthenticationService customAuthenticationService;

    public LoginController(UserService userService, CustomAuthenticationService customAuthenticationService) {
        this.userService = userService;
        this.customAuthenticationService = customAuthenticationService;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("authUser") LoginRequest loginRequest, Model model){
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute("authUser") LoginRequest loginRequest, Model model){
        Authentication authUser = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = customAuthenticationService.authenticate(authUser);
        System.out.println(authentication!=null);
        if(authentication != null){
            model.addAttribute("user", authentication.getPrincipal());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/home";
        }
        return "login";
    }
}
