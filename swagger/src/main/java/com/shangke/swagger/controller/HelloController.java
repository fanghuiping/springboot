package com.shangke.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "hell用户模块")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "测试seager")
    public String hello(){
        return "hello Spring Boot swagger";
    }
}
