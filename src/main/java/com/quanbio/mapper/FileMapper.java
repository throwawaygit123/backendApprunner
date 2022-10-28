package com.quanbio.mapper;

import com.quanbio.model.Files;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface FileMapper {
    /**
     * 将数据信息插入到数据库
     * Insert data information into the database
     * @param files
     */
    void insertFile(Files files);

    /**
     * 根据id获取文件
     * Get the file by ID
     * @param id
     * @return
     */
    Files selectFileById(String id);

}