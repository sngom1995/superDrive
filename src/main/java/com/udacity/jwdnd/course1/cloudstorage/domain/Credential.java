package com.udacity.jwdnd.course1.cloudstorage.domain;

public class Credential {
    private Integer credentialId;
    private String url;
    private String username;
    private String password;
    private String key;
    private Integer userid;



    public Credential() {
    }

    public Credential(Integer userid, String key, String password, String username, String url) {
        this.userid = userid;
        this.key = key;
        this.password = password;
        this.username = username;
        this.url = url;
    }

    public Credential(Integer credentialId, String url, String username, String password, String key, Integer userid) {
        this.credentialId = credentialId;
        this.url = url;
        this.username = username;
        this.password = password;
        this.key = key;
        this.userid = userid;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "credentialId=" + credentialId +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                ", userid=" + userid +
                '}';
    }
}
