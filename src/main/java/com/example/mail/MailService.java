package com.example.mail;

import javafx.scene.media.MediaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author zdb
 * @date 2020-03-15 22:14
 */
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    /*普通文本内容发送*/
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
    /*附加文本内容*/
    public void sendAttachFileMail(String from, String to, String subject,
                                   String content, File file) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //这里的true表示构建一个multipart类型的邮件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(file.getName(),file);
            javaMailSender.send(mimeMessage);
        } catch (MediaException | MessagingException e) {
            e.printStackTrace();
        }


    }

    //带图片
    public void sendMailWithImg(String from, String to, String subject,
                                String content,String[] srcPath,String[] resIds ){
        if (srcPath.length != resIds.length) {
            System.out.println("发送失败！");
            return;
        }
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            for (int i = 0; i < srcPath.length; i++) {
                //获取资源路径
                FileSystemResource res = new FileSystemResource(new File(srcPath[i]));
                helper.addInline(resIds[i],res);
            }
            javaMailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
