package com.spring.springbootmybatismutipledatasource.service;

import com.spring.springbootmybatismutipledatasource.bean.Money;
import com.spring.springbootmybatismutipledatasource.dao.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    /**
     * 根据名字查找客户
     */
    public Money selectMoneyById(int id){
        return moneyDao.findMoneyById(id);
    }
}
