package com.udacity.jwdnd.course1.cloudstorage.domain;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private String salt;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String lastName, String firstName, String salt, String password, String username) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salt = salt;
        this.password = password;
        this.username = username;
    }

    public User(Integer userId, String username, String password, String salt, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
