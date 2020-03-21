package com.example.mail.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdb
 * @date 2020-03-16 23:34
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;



}
