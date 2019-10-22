package com.spring.springbootmybatismutipledatasource.dao;

import com.spring.springbootmybatismutipledatasource.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;


@Qualifier("db1SqlSessionTemplate")
public interface UserDao{
    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(String name);
}
