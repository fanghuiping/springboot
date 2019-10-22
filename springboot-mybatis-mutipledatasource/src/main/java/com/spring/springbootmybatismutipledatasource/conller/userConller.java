package com.spring.springbootmybatismutipledatasource.conller;

import com.spring.springbootmybatismutipledatasource.bean.User;
import com.spring.springbootmybatismutipledatasource.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/*")
@Api("使用DataSource1的配置数据源查询")
public class userConller {
    @Autowired
    private UserService userService;
    @ApiOperation(value = ("按照名字查询"))
    @GetMapping("/query")
    public User testQuery(){
        return userService.selectUserByName("Daisy");
    }
}
