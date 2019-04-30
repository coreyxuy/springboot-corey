package com.itcorey.service;

import com.itcorey.mapper.NoticeMapper;
import com.itcorey.pojo.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description:
 * @Author: xuyp
 * @Date: 2019/4/30 11:52
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTest {

    @Resource
    private NoticeMapper noticeMapper;

    @Test
    public void test(){
        Notice notice = new Notice();
        notice.setId(1);
        Notice notice1 = noticeMapper.selectByPrimaryKey(1);
        System.out.println("======="+notice1);
    }
}