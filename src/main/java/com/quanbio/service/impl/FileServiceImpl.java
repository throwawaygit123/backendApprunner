//package com.quanbio.service.impl;
//
//import com.quanbio.mapper.FileMapper;
//import com.quanbio.model.Files;
//import com.quanbio.result.ResponseCode;
//import com.quanbio.result.Result;
//import com.quanbio.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//
//
//@Service
//public class FileServiceImpl implements FileService {
//
//    @Value("${file.save-path}")
//    private String savePath;
//    @Autowired
//    private FileMapper fileMapper;
//
//    @Override
//    public Result upLoadFiles(MultipartFile file) {
//        //设置支持最大上传的文件，这里是1024*1024*2=2M
//        long MAX_SIZE=2097152L;
//        //获取要上传文件的名称
//        String fileName=file.getOriginalFilename();
//        //如果名称为空，返回一个文件名为空的错误
//        if (StringUtils.isEmpty(fileName)){
//            return new Result(ResponseCode.FILE_NAME_EMPTY.getCode(),ResponseCode.FILE_NAME_EMPTY.getMsg(),null);
//        }
//        //如果文件超过最大值，返回超出可上传最大值的错误
//        if (file.getSize()>MAX_SIZE){
//            return new Result(ResponseCode.FILE_MAX_SIZE.getCode(),ResponseCode.FILE_MAX_SIZE.getMsg(),null);
//        }
//        //获取到后缀名
//        String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
//        //文件的保存重新按照时间戳命名
//        String newName = System.currentTimeMillis() + suffixName;
//        File newFile=new File(savePath,newName);
//        if (!newFile.getParentFile().exists()){
//            newFile.getParentFile().mkdirs();
//        }
//        try {
//            //文件写入
//            file.transferTo(newFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //将这些文件的信息写入到数据库中
//        Files files=new Files(newFile.getPath(),fileName,suffixName);
//        fileMapper.insertFile(files);
//        return new Result(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),"上传成功");
//    }
//
//    //根据id获取文件信息
//    @Override
//    public Files getFileById(String id) {
//        Files files = fileMapper.selectFileById(id);
//        return files;
//    }
//
//    //将文件转化为InputStream
//    @Override
//    public InputStream getFileInputStream(Files files) {
//        File file=new File(files.getFilepath());
//        try {
//            return new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
