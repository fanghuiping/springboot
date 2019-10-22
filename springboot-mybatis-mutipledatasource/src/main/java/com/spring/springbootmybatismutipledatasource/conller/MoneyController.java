package com.spring.springbootmybatismutipledatasource.conller;

import com.spring.springbootmybatismutipledatasource.bean.Money;
import com.spring.springbootmybatismutipledatasource.service.MoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money/*")
@Api("使用DataSource2的配置数据源查询")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @ApiOperation(value = "按id查询")
    @GetMapping("/query")
    public Money testQuery(){
        return moneyService.selectMoneyById(2);
    }
}
