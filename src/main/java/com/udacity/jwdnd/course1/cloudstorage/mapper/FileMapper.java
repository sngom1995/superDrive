package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.domain.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid=#{userId}")
    List<File> findFilesByUserId(Integer userId);

    @Insert("INSERT INTO files (filename, contenttype, filesize, userid, filedata) VALUES(#{filename}, #{contenttype}, #{filesize}, #{userid}, #{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(File file);

    @Delete("DELETE FROM files WHERE fileid = #{fileId}")
    void deleteFile(Integer fileId);

    @Select("SELECT * FROM files WHERE fileid = #{fileId}")
    File findFileById(Integer fileId);

    @Select("SELECT * FROM files WHERE filename = #{fileName}")
    File findFileByFilename(String fileName);

}
