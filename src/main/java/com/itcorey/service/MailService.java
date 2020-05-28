package com.itcorey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author corey
 * @date 2018/10/13 23:05
 */
@Service
public class MailService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());


    //注入配置文件
    @Value("${spring.mail.username}")
    private String from;

    //注入发送者
    @Autowired
    private JavaMailSender javaMailSender;

    public void sayHello() {
        System.out.println("===========>HelloWorld!");
    }

    /**
     * @param to      收件者
     * @param subject 发件主题
     * @param contet  内容
     */
    public void sendSimplMail(String to, String subject, String contet) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(contet);
        message.setFrom(from);
        //发送简单邮件
        javaMailSender.send(message);

    }


    /**
     * 发送html邮件
     */
    public void sendHtmlEmail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        javaMailSender.send(message);

    }

    /**
     * 发送附件邮件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filepath) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        //读取附件路径
        FileSystemResource file = new FileSystemResource(new File(filepath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);
    }


    /**
     * 发送图片邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws MessagingException
     */
    public void sendInLinResource(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        logger.info("======>" + "静态邮箱地址开始发送!", to, subject, content, rscPath, rscId);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            logger.info("发送静态邮件成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("发送静态邮件失败", e);
        }

        javaMailSender.send(message);
    }

}
