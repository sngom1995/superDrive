package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.domain.File;

import java.util.List;

public interface IFileService {
    void createFile(File file);
    List<File> getAllFilesByUserId(int userId);
    File getFileById(int fileId);
    void deleteFile(int fileId);
    File getFileByName(String fileName);
}
