package com.shangke.springbootpzwjzr.conller;


import com.shangke.springbootpzwjzr.bean.Person;
import com.shangke.springbootpzwjzr.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "测试SpringBoot配置文件注入")
public class UserCon {
    @Autowired
    User user;

    @Autowired
    Person person;

    @GetMapping("/fang")
    @ApiOperation(value = "测试单体注入")
    public String fang(){
        return user.toString();
    }

    @GetMapping("/fang2")
    @ApiOperation(value = "测试批量注入")
    public String fang2(){
        return person.toString();
    }


}
