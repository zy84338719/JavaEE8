package com.murphyyi.mail.Service;

import com.murphyyi.mail.hello.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    String to = "zy84338719@hotmail.com";
    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;
    @Test
    public void sayHelloTest(){
        mailService.sayHello();
    }


    @Test
    public void sendMailTest(){
        mailService.sendMail("zy84338719@hotmail.com","这是我的第一封邮件","这是java-spring-boot-mail发送的");
    }

    @Test
    public void sendHtmlMailTest() {

        String content = "<html><body><h1>这是一封HTML电子邮件</h1></body></html>";
        mailService.sendHtmlMail(to,"这是一封HTML邮件",content);
    }

    @Test
    public void sendAttachmentTest() {
        String content = "<html><body><h1>这是一封带附件的电子邮件</h1></body></html>";
        String filePath = "/Users/zhangyi/miio.sh";
        mailService.sendAttachmentMail(to,"这是一封带有附件的电子邮件", content, filePath);
    }

    @Test
    public void sendInlineMailTest() {
        String[] images = {"/Users/zhangyi/Desktop/zp.png","/Users/zhangyi/Desktop/PyCharmMac.png"};
        String[] srcIds = {"001","002"};
        StringBuffer content = new StringBuffer();
        content.append("<html><body>这是一封带有图片的邮件");
        for (String srcId:srcIds
             ) {
            content.append("<img src=\'cid:"+srcId+"\'></img>");
        }
        content.append("</body></html>");
        mailService.sendInlineResourceMail(to,"这是一封带图片的邮件",content.toString(),srcIds,images);
    }

    @Test
    public void sendTemplateMailTest(){
        Context context = new Context();
        context.setVariable("id","006");
        String emailContext = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail(to,"这是一个模版邮件",emailContext);
    }
}
