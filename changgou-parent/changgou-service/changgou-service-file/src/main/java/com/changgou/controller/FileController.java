package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhaowuting
 * @date 2022-03-03 10:48
 */

@RequestMapping("/upload")
@CrossOrigin
@RestController
public class FileController {


    /**
     * 文件上传
     * @return new Result()
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file) throws Exception
    {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),  //文件名
                file.getBytes(),             //文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())  //文件扩展名
        );

        //调用FastDFSClient类将文件上传到FastDFS中
        String[] uploadFile = FastDFSClient.upload(fastDFSFile);
        return new Result(true, StatusCode.OK,"上传成功",uploadFile);
    }
}
