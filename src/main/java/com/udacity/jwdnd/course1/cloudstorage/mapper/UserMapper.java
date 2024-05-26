package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User findUserByUsername(String username);
    @Select("SELECT * FROM USERS WHERE userid = #{id}")
    User findUserById(Integer id);

    @Select("SELECT * FROM USERS")
    List<User> findAllUsers();

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(User user);

    @Delete("DELETE FROM users WHERE userid = #{id}")
    void deleteUser(Integer id);
}
