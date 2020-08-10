package com.springstudy.springzj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
//读取配置文件位置
@PropertySource("classpath:userthree.properties")
//@Import(BaseConfig.class)
@ConfigurationProperties(prefix = "user")
public class ReadConfig {
    /**
     * 使用ConfigurationProperties注解时 要用有set方法
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }



    //@Value("${user.Id}")
    private String id;
    private String name;
    private String age;

    public void showConfigId() {
        System.out.println("读取配置文件id" + id);
    }

    public void showAge() {
        System.out.println("读配置文件age=" + age);
    }
    //读取不到
    public void showConfigName(@Value("${user.name}") String name) {
        System.out.println("读取配置文件name" + name);
    }
}
