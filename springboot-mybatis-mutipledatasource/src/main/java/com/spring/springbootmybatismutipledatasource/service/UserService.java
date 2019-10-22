package com.spring.springbootmybatismutipledatasource.service;

import com.spring.springbootmybatismutipledatasource.bean.User;
import com.spring.springbootmybatismutipledatasource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name){
        return userDao.findUserByName(name);
    }
}
