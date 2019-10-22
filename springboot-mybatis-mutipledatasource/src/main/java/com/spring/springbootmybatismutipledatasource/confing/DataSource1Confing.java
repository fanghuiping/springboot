package com.spring.springbootmybatismutipledatasource.confing;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.engine.jdbc.connections.spi.DataSourceBasedMultiTenantConnectionProviderImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configurable
@MapperScan(basePackages = "com.spring.springbootmybatismutipledatasource.dao",sqlSessionFactoryRef = "dp1SqlSession")
public class DataSource1Confing{
    /**
     * 生成数据源
     */
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 SqlSessionFactory
     */
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //  bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db1/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}