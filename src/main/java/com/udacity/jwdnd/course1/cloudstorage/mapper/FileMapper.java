package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.domain.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid=#{userId}")
    List<File> findFilesByUserId(int userId);

    @Insert("INSERT INTO FILES (filename,contenttype,fileSize,filedata,userid) VALUES(#{filename},#{contenttype},#{fileSize},#{filedata},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    void deleteFile(int fileId);

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File findFileById(int fileId);

    @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
    File findFileByFilename(String fileName);

}
