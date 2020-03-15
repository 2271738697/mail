package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author zdb
 * @date 2020-03-15 22:14
 */
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(String from, String to, String cc,
                               String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        /*发送人*/
        simpleMailMessage.setFrom(from);
        /*收件人*/
        simpleMailMessage.setTo(to);
        /*抄送人*/
        simpleMailMessage.setCc(cc);
        /*主题*/
        simpleMailMessage.setSubject(subject);
        /*内容*/
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);

    }


}
