package com.itcorey.controller;

import com.itcorey.pojo.Notice;
import com.itcorey.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 通知
 * @Author: xuyp
 * @Date: 2019/4/30 14:24
 * @Modified By:
 */
@Controller
@RequestMapping("/corey")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * @return
     */
    @RequestMapping("/babyList")
    @ResponseBody
    public String babyList() {
        return "hello!!";
    }


    /**
     * @return
     */
    @RequestMapping("/notice")
    @ResponseBody
    public Notice queryNote() {
        Integer id = 1;
        Notice notice = noticeService.queryUser(id);
        System.out.println("==="+notice);
        return notice;
    }
}
