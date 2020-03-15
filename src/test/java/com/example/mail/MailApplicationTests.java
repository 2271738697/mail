package com.example.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    MailService mailSrervice;

    @Test
    void contextLoads() {
        mailSrervice.sendSimpleMail("2271738697@qq.com",
                "1050881627@qq.com",
                "1050881627@qq.com",
                "测试主题",
                "内容");
        System.out.println("成功");
    }

}
