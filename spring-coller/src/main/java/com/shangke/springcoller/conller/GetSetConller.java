package com.shangke.springcoller.conller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * get方式url传承
 */
@RestController
@Api("get方式url")
public class GetSetConller {
    /*
     * @PathVariable
     * 运行方式http://localhost:8080/hello/lisi
     * 输出hello:lisi
     */
    @GetMapping("/hello/{name}")
    @ApiOperation(value = "hello使用")
    public String hello(@PathVariable("name") String name) {
        System.out.println("获取到的name是" + name);
        return "hello:" + name;
    }

    /**
     * @RequestParam
     * http://localhost:8080/hello?name="fang"
     * 输出name:fang
     */
    @GetMapping("/hello2")
    @ApiOperation(value = "hello2使用")
    public String hello2(@RequestParam("name") String name) {
        System.out.println("获取的name名是" + name);
        return "name:" + name;
    }

    /**
     * @RequestParam进阶版 value 需要放入的值 defaultValue 默认值
     * 需要注意的是，值不能为空，如果为空，代码报错
     * ps:解决办法，要么使用defaultValue默认值，要么使用required = false：标准参数是非必须的，默认true
     * @param name
     * @return
     */
    @GetMapping("/hello3")
    @ApiOperation(value = "hello3使用")
    public String hello3(@RequestParam(value = "name",defaultValue = "admin")String name){
        System.out.println("获取的name是："+name);
        return "name:"+name;
    }

}
