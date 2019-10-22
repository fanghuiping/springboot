package com.shangke.springboot2pzwjsy.conller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Conller {
    @GetMapping("/fang")
    @ResponseBody
    public String fang(@RequestParam(value = "hellowrold",defaultValue = "HelloWorid")String hello){
        return hello;
    }
}
