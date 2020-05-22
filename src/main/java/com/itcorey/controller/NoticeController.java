package com.itcorey.controller;

import com.itcorey.pojo.Notice;
import com.itcorey.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 通知
 * @Author: xuyp
 * @Date: 2019/4/30 14:24
 * @Modified By:
 */
@Controller
@Api(tags = "通知类")
@RequestMapping("/corey")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * @return
     */
    @RequestMapping(value = "/babyList",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("通知列表")
    public String babyList() {
        return "hello!!";
    }


    /**
     * @return
     */
    @RequestMapping(value = "/notice",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("根据id查询同志信息")
    public Notice queryNote() {
        Integer id = 6;
        Notice notice = noticeService.queryUser(id);
        System.out.println("==="+notice.toString());
        return notice;
    }
}
