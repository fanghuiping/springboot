package com.shangdu.springbootmybatisannotation.controller;

import com.shangdu.springbootmybatisannotation.mapper.UserMapper;
import com.shangdu.springbootmybatisannotation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/*")
public class UserController {
    @SuppressWarnings("all")
    @Autowired
    UserMapper userMapper;

    @GetMapping("list")
    public List<User> list(){
        return userMapper.list();
    }

    @GetMapping("list/{username}")
    public List<User> listByUsername(@PathVariable("username") String username){
        return userMapper.findByUsername(username);
    }
    @GetMapping("get/{username}/{password}")
    public User get(@PathVariable("username")String username,@PathVariable("password")String password){
        return userMapper.get(username,password);
    }
    @GetMapping("get/bud/{username}/{password}")
    public User getBadUser(@PathVariable("username")String username,@PathVariable("password")String password){
        return userMapper.getBadUser(username,password);
    }


}
