package com.udacity.jwdnd.course1.cloudstorage.domain;

public class File {
    private Integer fileId;
    private String fileName;
    private String fileType;
    private Integer fileSize;
    private Integer userId;
    private byte[] fileData;

    public File() {
    }

    public File(byte[] fileData, Integer userId, Integer fileSize, String fileType, String fileName) {
        this.fileData = fileData;
        this.userId = userId;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.fileName = fileName;
    }

    public File(Integer fileId, String fileName, String fileType, Integer fileSize, Integer userId, byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
