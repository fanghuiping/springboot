package com.shangdu.springbootmybatisannotation.mapper;

import com.shangdu.springbootmybatisannotation.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface UserMapper {
    @Results({
            @Result(property = "userId",column = "USER_ID"),
            @Result(property = "username",column = "USERNAME"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "mobileNum",column = "PHONE_NUM")
    })
    /**
     * 方法1：使用注解编写sql
     * @return
     */
    @Select("select * from t_user")
    List<User> list();

    /**
     * 方法2:使用注解指定某个工具类的方法来编写sql
     * @return
     */
    // selectProvider type=指定类  method=指定类中的方法
    @SelectProvider(type = UserSqlProvider.class,method = "listByUsername")
    List<User> findByUsername(String username);

    /**
     * 延伸1:上述两种方法都可以使用@Results注解来指定结果集的映射关系.
     *
     * ps:如果符合下划线转驼峰的匹配项可以直接省略不写
     */
    @Results({
            @Result(property = "userId",column = "USER_ID"),
            @Result(property = "username",column = "USERNAME"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "mobileNum",column = "PHOWE_NUM")
    })
    @Select("select * from t_user")
    List<User> listSample();

    /**
     * 延伸：无论什么方式,如果涉及多个参数,*则必须加上@Param注解*,否则无法使用EL表达式获取参数。
     */
    @Select("select * from t_user where username like #{username} and password like #{password}")
    User get(@Param("username") String username, @Param("password") String password);


    @SelectProvider(type = UserSqlProvider.class, method = "getBadUser")
    User getBadUser(@Param("username") String username, @Param("password") String password);




}
