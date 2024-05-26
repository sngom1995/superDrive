package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.domain.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM credentials WHERE userid = #{userId}")
    List<Credential> findCredentialsByUserId(Integer userId);

    @Insert("INSERT INTO credentials (url, username, key, password, userid) VALUES(#{url}, #{username}, #{key}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insertCredential(Credential credential);

    @Update("UPDATE credentials SET url = #{url}, username = #{username}, key = #{key}, password= #{password}, userid = #{userid} WHERE credentialid = #{credentialId}")
    void updateCredential(Credential credential);

    @Delete("DELETE FROM credentials WHERE credentialid = #{credentialId}")
    void deleteCredential(Integer credentialId);

    @Select("SELECT * FROM credentials WHERE credentialid = #{credentialId}")
    Credential findCredentialById(Integer credentialId);
}
