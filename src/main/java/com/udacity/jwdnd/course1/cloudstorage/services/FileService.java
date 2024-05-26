package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.domain.File;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService implements IFileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public void createFile(File file) {

        fileMapper.insertFile(file);
    }

    @Override
    public List<File> getAllFilesByUserId(int userId) {
        return fileMapper.findFilesByUserId(userId);
    }

    @Override
    public File getFileById(int fileId) {
        return fileMapper.findFileById(fileId);
    }

    @Override
    public void deleteFile(int fileId) {
        fileMapper.deleteFile(fileId);
    }

    @Override
    public File getFileByName(String fileName) {
        return fileMapper.findFileByFilename(fileName);
    }

    public Boolean isFileExist(String fileName) {
        return fileMapper.findFileByFilename(fileName) != null;
    }
}
