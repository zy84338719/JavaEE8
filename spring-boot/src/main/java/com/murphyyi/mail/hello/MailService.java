package com.murphyyi.mail.hello;

import org.apache.naming.factory.SendMailFactory;
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
import java.nio.file.FileSystem;

@Service
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    private JavaMailSender mailSender;
    public void sayHello(){
        System.out.println("HelloService.sayHello");
    }
    public void sendMail(String to, String subject,
                         String content){

        logger.info("开始发送邮件:{}{}{}{}",to,subject,content,from);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        mailSender.send(simpleMailMessage);
    }

    public void sendHtmlMail(String to, String subject,
                             String content){
        logger.info("开始发送邮件:{}{}{}{}",to,subject,content,from);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);

        } catch (MessagingException e) {
            logger.error("邮件发送失败",e);
        }


    }

    public void sendAttachmentMail(String to, String subject,
                                   String content, String filePath) {
        logger.info("开始发送邮件:{}{}{}{}",to,subject,content,from);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(content, true);
            helper.setSubject(subject);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String filename = file.getFilename();
            // 这里是一个数组可以直接进行多个附件发送
            helper.addAttachment(filename,file);
            helper.addAttachment(filename,file);
            mailSender.send(message);
            logger.info("邮件发送成功");
        } catch (MessagingException e) {
            logger.error("邮件发送失败",e);
        }

    }

    public void sendInlineResourceMail(String to, String subject,
                                   String content, String[] rscId, String[] rscPath) {
        logger.info("开始发送邮件:{}{}{}{}",to,subject,content,from);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(content, true);
            helper.setSubject(subject);
            int i = 0;
            for (String path: rscPath
            ) {
                FileSystemResource rsc = new FileSystemResource(path);
                helper.addInline(rscId[i],rsc);
                i++;
            }
            mailSender.send(message);
            logger.info("邮件发送成功");
        } catch (MessagingException e) {
            logger.error("邮件发送失败",e);
        }



    }
}
