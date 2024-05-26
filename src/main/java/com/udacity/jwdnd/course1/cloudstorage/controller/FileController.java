package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.domain.File;
import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file, Authentication authentication, RedirectAttributes redirectAttributes) throws IOException {
        String uploadError = null;

        User user = userService.getUserByUsername(authentication.getName());

        if (file.isEmpty()) {
            uploadError = "Please select a non-empty file.";
        }

        if (fileService.isFileExist(file.getOriginalFilename())){
            uploadError = "The file already exists.";

        }

        if(uploadError!=null) {
            redirectAttributes.addFlashAttribute("error", uploadError);
            return "redirect:/result?error";
        }
        File fileEntity = new File();
        System.out.println(file.getContentType());
        fileEntity.setFilename(file.getOriginalFilename());
        fileEntity.setContenttype(file.getContentType());
        fileEntity.setUser_id(user.getUserId());
        fileEntity.setFiledata(file.getBytes());
        fileEntity.setFileSize(file.getSize());
        System.out.println(fileEntity.toString());
        fileService.createFile(fileEntity);
        return "redirect:/result?success";
    }

    @GetMapping("/files/delete/{fileId}")
    public String deleteFile(@PathVariable Integer fileId, RedirectAttributes redirectAttributes) {
        if(fileId > 0){
            fileService.deleteFile(fileId);
            return "redirect:/result?success";
        }

        redirectAttributes.addAttribute("error", "Unable to delete the file.");
        return "redirect:/result?error";
    }

    @GetMapping("/files/download/{fileId}")
    public ResponseEntity<?> handleFileDownload(@PathVariable Integer fileId, Model model, Authentication authentication) {
        System.out.println("fileId: " + fileId);
        File file = fileService.getFileById(fileId);
        System.out.println(file);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        System.out.println(file.toString());
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.getFileSize())
                .contentType(MediaType.parseMediaType(file.getContenttype()))
                .body(new ByteArrayResource(file.getFiledata()));
    }

}
