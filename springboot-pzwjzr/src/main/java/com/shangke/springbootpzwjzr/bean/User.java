package com.shangke.springbootpzwjzr.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 单值注入
 */
/* 使用Component将本类放到容器中 */
@Component
@Data
public class User {
    /* 使用@Value读取配置文件 */
    @Value("${user.id}")
    private String id;
    @Value("${user.username}")
    private String username;
    @Value("${user.pwd}")
    private String pwd;
}
