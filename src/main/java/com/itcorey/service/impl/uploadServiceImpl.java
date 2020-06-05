package com.itcorey.service.impl;

import com.itcorey.mapper.UplocalFileMapper;
import com.itcorey.pojo.UplocalFile;
import com.itcorey.service.uploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname uploadServiceImpl
 * @Description TODO
 * @Date 2020/6/2 17:37
 * @Created by corey
 */
@Service
public class uploadServiceImpl implements uploadService {

    private static final Logger logger = LoggerFactory.getLogger(uploadServiceImpl.class);

    /**
     * 支持图片类型
     */
    private static final List<String> CONTENT_TYPE = Arrays.asList("image/gif", "image/jpeg", "image/png");

    @Resource
    private UplocalFileMapper uplocalFileMapper;


    @Override
    public String uploadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        //建议文件类型
        String contentType = file.getContentType();
        if (!CONTENT_TYPE.contains(contentType)) {
            logger.info("上传文件类型不符合要求", originalFilename);
            return "false";
        }
        try {
            //校验内容
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read == null) {
                logger.info("文件类容不符合法:", originalFilename);
                return "false";
            }
            //保存文件
            file.transferTo(new File("D:\\Img" + originalFilename));
            //写到数据库
            UplocalFile uplocal = new UplocalFile();
            uplocal.setEnabled("1");
            uplocal.setProfilePhoto("/Img/" + originalFilename);
            int insert = uplocalFileMapper.insertSelective(uplocal);
            if (insert > 1) {
                logger.info("文件写入成功");
            }
        } catch (IOException e) {
            logger.error("服务器内部错误->:{}", originalFilename);
            e.printStackTrace();
        }
        return "http://**.***.com/" + originalFilename;
    }
}
