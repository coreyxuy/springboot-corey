package com.itcorey.service;

import com.itcorey.mapper.NoticeMapper;
import com.itcorey.pojo.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * @author corey
 * @date 2018/10/13 23:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;




    @Test
    public void test() {
        mailService.sayHello();
    }

    /**
     * 邮件测试代码
     */
    @Test
    public void senSimpleMailTest() {
        //收件者
        String cover = "coreyxuyong@163.com";
        //主题
        String theme = "邮件测试";
        //内容
        String content = "springboot邮件发送..";
        mailService.sendSimplMail(cover, theme, content);
    }

    /**
     * 发送html邮件
     */
    @Test
    public void sendHtmlEmail() throws MessagingException {
        String conten = "<html>\n" +
                "<body>\n" +
                "<h4> 这是一封html邮件!</h4>\n" +
                "</body>\n" +
                "</html>";
        for (int i = 0; i < 2; i++) {
            mailService.sendHtmlEmail("coreyxuyong@163.com", "这是一封html邮件", conten);
        }
    }

    /**
     * 邮件添加附件
     */
    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String file = "D:\\Spring Boot基.rar";
        mailService.sendAttachmentsMail("coreyxuyong@163.com", "这是一封带附件的邮件", "这是一封带附件的邮件的电子邮件", file);
    }

    /**
     * 发送图片邮件
     *
     * @throws MessagingException
     */
    @Test
    public void sendInLinResource() throws MessagingException {
        String inmPath = "D:\\1.png";
        String rscId = "corey001";
        String content = "<html><body>这是一份带有图片的电子邮件:<img src=\'cid:" + rscId + " \'></img></body></html>";
        mailService.sendInLinResource("coreyxuyong@163.com", "这是一封带图片的邮件",
                content, inmPath, rscId);
    }

    /**
     * 模板引擎发送邮件
     */
    @Test
    public void setTemplateEngine() throws MessagingException {
        Context context = new Context();
        context.setVariable("id", 007);
        String emailTemplate = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlEmail("coreyxuyong@163.com", "这是一封模板邮件", emailTemplate);
    }


}
