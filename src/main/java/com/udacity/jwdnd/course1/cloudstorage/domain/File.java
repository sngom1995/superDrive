package com.udacity.jwdnd.course1.cloudstorage.domain;

public class File {
    private int fileId;
    private String filename;
    private  String contenttype;
    private long fileSize;
    private byte[] filedata;
    private Integer userid;


    public File(int file_id, String filename, String contenttype, long fileSize, byte[] filedata, Integer user_id) {
        this.fileId = file_id;
        this.filename = filename;
        this.contenttype = contenttype;
        this.fileSize = fileSize;
        this.filedata = filedata;
        this.userid = user_id;
    }
    public int getUser_id() {
        return userid;
    }
    public void setUser_id(int user_id) {
        this.userid = user_id;
    }
    public int getFileId() {
        return fileId;
    }
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getContenttype() {
        return contenttype;
    }
    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
    public long getFileSize() {
        return fileSize;
    }
    public void setFileSize(long l) {
        this.fileSize = l;
    }
    public byte[] getFiledata() {
        return filedata;
    }
    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }
    public File() {

    }
    public File(String filename, String contenttype, long fileSize, byte[] filedata) {

        this.filename = filename;
        this.contenttype = contenttype;
        this.fileSize = fileSize;
        this.filedata = filedata;
    }
    @Override
    public String toString() {
        return "Files [file_id=" + fileId + ", filename=" + filename + ", contenttype=" + contenttype + ", fileSize="
                + fileSize + ", filedata=" + filedata + ", user_id=" + userid + "]";
    }



}
