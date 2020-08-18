package com.springstudy.springzj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
//开启定时任务注解
public class SchedulingConfig {
    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(fixedRateString ="3000")

    public void showSchelduling() {
        //System.out.println("定时任务........当前是时间" + LocalDateTime.now());
    }
}
