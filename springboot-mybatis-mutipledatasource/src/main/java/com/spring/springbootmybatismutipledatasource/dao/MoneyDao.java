package com.spring.springbootmybatismutipledatasource.dao;

import com.spring.springbootmybatismutipledatasource.bean.Money;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;

@Qualifier("db2SqlSessionTemplate")
public interface MoneyDao{
    /**
     * 通过id 查看工资详情
     */
    @Select("SELECT * FROM money WHERE id = #{id}")
    Money findMoneyById(@Param("id") int id);
}
