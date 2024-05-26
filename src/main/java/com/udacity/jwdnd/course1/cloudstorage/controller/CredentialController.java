package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.domain.Credential;
import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CredentialController {
    private final UserService userService;
    private final CredentialService credentialService;

    public CredentialController(UserService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @PostMapping("/credentials")
    public String addCredential(@ModelAttribute("credential") Credential credential, Model model, Authentication authentication) {
        User user = userService.getUserByUsername(authentication.getName());
        try {
            if (credential.getCredentialId()!=null){
                credential.setUserid(user.getUserId());
                credentialService.updateCredential(credential);
            }
            else {
                credential.setUserid(user.getUserId());
                credentialService.saveCredential(credential);
            }
            return "redirect:/result?success";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/result?error";
        }
    }

    @GetMapping("/credentials/{id}")
    public String displayCredential(@PathVariable Integer id, Model model) {
        try {
            credentialService.deleteCredentialById(id);
            return "redirect:/result?success";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/result?error";
        }
    }

}
