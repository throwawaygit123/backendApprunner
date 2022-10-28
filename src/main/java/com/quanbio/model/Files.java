package com.quanbio.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("file")
public class Files implements Serializable {
    private static final long serialVersionUID=1L;

    private int id;
    /**
     * 文件存储路径
     */
    private String filepath;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 文件后缀名
     */
    private String filesuffix;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesuffix() {
        return filesuffix;
    }

    public void setFilesuffix(String filesuffix) {
        this.filesuffix = filesuffix;
    }

    public Files(String filepath, String filename, String filesuffix) {
        this.filepath = filepath;
        this.filename = filename;
        this.filesuffix = filesuffix;
    }
}
