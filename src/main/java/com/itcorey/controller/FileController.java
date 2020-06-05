package com.itcorey.controller;

import com.itcorey.service.uploadService;
import com.itcorey.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname FileController
 * @Description 文件上传
 * @Date 2020/6/2 16:31
 * @Created by corey
 */
@RestController
@Api(tags = "文件上传")
@RequestMapping("/file")
public class FileController {
    private final static Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private uploadService uploadService;

    @PostMapping("/image")
    @ApiOperation("上传图片")
    public R uploadImg(@RequestParam("file") MultipartFile file) {
        String url = uploadService.uploadImage(file);
        return R.ok().data("url",url).message("上传图片成功!");
    }

}
