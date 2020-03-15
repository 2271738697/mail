package com.example.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    MailService mailSrervice;

    @Test
    void contextLoads() {
        /*发送人*/
        String from ="2271738697@qq.com";
        /*收件人*/
        String to ="1050881627@qq.com";
        /*c抄写人*/
        String subject ="1050881627@qq.com";
        /*主题*/
        String content ="测试主题";


      /*  mailSrervice.sendSimpleMail("2271738697@qq.com",
                "1050881627@qq.com",
                "1050881627@qq.com",
                "测试主题",
                "内容");
        System.out.println("成功");*/

        //测试附带文本
        mailSrervice.sendAttachFileMail(from,to,subject,content,new File("C://Users/Administrator/Desktop/已完成任务/返利功能.txt"));

        //测试上传图片
        mailSrervice.sendMailWithImg(from,to,"这是图片邮件","<div>hello,这是一封带图片的邮件"+
                "这图片是：<div><img src='cid:po1'/></div></div>",new String[]{"C://Users/Administrator/Pictures/bug.jpg"},new String[]{"p01"});

    }

}
