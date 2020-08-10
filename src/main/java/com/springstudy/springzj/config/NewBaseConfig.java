package com.springstudy.springzj.config;

import com.springstudy.springzj.pojo.English;
import com.springstudy.springzj.pojo.Math;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class NewBaseConfig {
    @Profile("english")
    @Bean
    public English getEnglish() { return new English(); }
    @Profile("math")
    @Bean
    public Math getMath() { return new Math();}
}
