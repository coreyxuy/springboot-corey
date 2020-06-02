package com.itcorey.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname uploadService
 * @Description 图片上传服务类
 * @Date 2020/6/2 17:36
 * @Created by corey
 */
public interface uploadService {

    String uploadImage(MultipartFile file);
}
