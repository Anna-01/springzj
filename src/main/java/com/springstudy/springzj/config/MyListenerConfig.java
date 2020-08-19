package com.springstudy.springzj.config;

import com.springstudy.springzj.spkz.MyApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyListenerConfig {
    @Bean
    public MyApplicationListener applicationListener() {
        return  new MyApplicationListener();
    }
}
