package com.shangke.springbootpzwjzr.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Data
/* 想要@ConfigurationProperties中，就要使用@Component将本类放到容器中 */
@Component
/* @PropertySource 只能够读取peoperties后缀，不能够读取yml
 * 如果要读取yml的需要处写XX类里的方法 */
@PropertySource(value = {"classpath:person.properties"})
/* @ConfigurationProperties注释，读取出现配置文件中`prefix`中的前缀中，字段自动匹配本类中的自字段 */
@ConfigurationProperties(prefix = "person")
public class Person {
    private  String lastName;
    private  Integer age;
    private  Boolean boss;
    private  Date birth;
    private Map<String,Object> maps;
    private List<String> lists;
    private Dog dog;
}
