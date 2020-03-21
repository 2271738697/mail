package com.example.mail.redis;

import org.omg.DynamicAny.DynValueOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis保存数据
 * @author zdb
 * @date 2020-03-16 23:37
 */
@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test01")
    public Object test1(){

        ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name","三国");
        String name = ops1.get("name");

        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("红楼梦");
        b1.setAuthor("曹雪芹");
        ops2.set("b1",b1);
        Book book = (Book) ops2.get("b1");
        System.out.println(book);
        return book;
    }

}
