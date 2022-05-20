package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailClient {

    private static final Logger logger=LoggerFactory.getLogger(MailClient.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("{spring.mail.username}")
    private String from;

    //发送html格式的邮件

    public void sendMail(String to,String subject,String content)  {
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            javaMailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            System.out.println("发送邮件失败:"+e.getMessage());
        }

    }
}
