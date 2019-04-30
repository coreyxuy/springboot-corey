package com.itcorey.service.impl;

import com.itcorey.mapper.NoticeMapper;
import com.itcorey.pojo.Notice;
import com.itcorey.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: xuyp
 * @Date: 2019/4/30 14:54
 * @Modified By:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Notice queryUser(Integer id) {
        Notice notice = noticeMapper.selectNotice(id);
        return notice;
    }
}
