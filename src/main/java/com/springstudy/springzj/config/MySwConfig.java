package com.springstudy.springzj.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//事务配置
@Configuration
public class MySwConfig {
    //数据源  配置HikariDataSource数据源
    @Bean
    public HikariDataSource dataSource() throws Exception{
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("");
        dataSource.setPassword("");
        dataSource.setUsername("");
        return dataSource;
    }
}
