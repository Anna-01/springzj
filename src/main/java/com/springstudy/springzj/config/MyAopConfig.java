package com.springstudy.springzj.config;

import com.springstudy.springzj.aop.LogAspects;
import com.springstudy.springzj.aop.MathJiSuan;
import com.springstudy.springzj.qxlj.aop.LoginAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop 动态代理：面向切面编程，。 在程序运行区间   动态地将某段代码 切到指定方法 指定位置
 * 在方法运行之前 之后 抛出异常等
 * 1.前置通知@Before
 * 2.后置通知，@After
 * 3，返回通知@AfterReturning，
 * 4，异常通知@AfterThrowing
 * 5.环绕通知，@Around 动态代理 手动 调用方法运行 joinPoint.procssed();-+
 */
@Configuration
//开启基于注解版的切面功能
@EnableAspectJAutoProxy
public class MyAopConfig {
    //业务逻辑类加入容器中
    @Bean
    public MathJiSuan mathJiSuan () {
        return new MathJiSuan();
    }

    //切面类加入容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
    @Bean
    public LoginAop loginAop() {
        return new LoginAop();
    }


}
