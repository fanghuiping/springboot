package com.shangke.springcoller.conller;

import io.swagger.annotations.Api;
import com.shangke.springcoller.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * POST方式传递数据
 */
@RestController
@Api("POST方式传递数据")
public class PostConller {
    public static Logger log = LoggerFactory.getLogger(PostConller.class);

    @PostMapping("/user")
    @ApiOperation(value = "post方式传递数据")
    public String add(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        log.info(name + "" + age);
        return "name" + name + "\nage" + age;
    }
    //不理解
    @PostMapping("user2")
    @ApiOperation(value = "POST传递字符串文本")
    public String postStirng(HttpServletRequest request) {
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
//  成功
    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("@requestbody接收参数")
    public Map<String,Object> save(@RequestBody User user){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user",user);
        return map;
    }
//    报错
//    @PostMapping("/user")
//    @ApiOperation("@requestbody接收参数")
//    public String user(@RequestBody User user){
//        log.info(user.toString());
//        return null;
//    }



}
