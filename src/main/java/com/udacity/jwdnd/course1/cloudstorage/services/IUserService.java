package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.domain.User;

public interface IUserService {
    Integer addUser(User user);
    User getUserById(Integer id);
    User getUserByUsername(String username);
    Boolean isUsernameExist(String username);
}
