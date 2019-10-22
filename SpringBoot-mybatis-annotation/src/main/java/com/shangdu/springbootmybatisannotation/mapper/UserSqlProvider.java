package com.shangdu.springbootmybatisannotation.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 主要用途：根据复杂的业务需求来动态生成SQL.
 * <p>
 * 目标：使用Java工具类来替代传统的XML文件.(例如：UserSqlProvider.java <-- UserMapper.xml)
 */
public class UserSqlProvider {
    /**
     * 方式1：在工具类中自己手动编写sql;
     */
    public String listByUsername(){
        return "select * from t_user where username = #{username}";
    }
    /**
     *  方法2:也可以使用官方提供的API来编写动态sql
     */
    public String getBadUser(@Param("username") String username,@Param("password")String password){
        return new SQL(){{
            SELECT("*");
            FROM("t_user");
            if(username !=null && password != null){
                WHERE("username like #{username} and password like #{password}");
            }else {
                WHERE("1=2");
            }
        }}.toString();
    }

}
