package com.springstudy.springzj;

import com.springstudy.springzj.aop.MathJiSuan;
import com.springstudy.springzj.config.MyAopConfig;
import com.springstudy.springzj.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@SpringBootApplication注解中含有@ComponentScan   springboot 核心 约定大于配置
@SpringBootApplication
//放在这里就扫描不到了
//@ComponentScan({"com.springstudy.springzj.pojo"})

//在 Spring Boot启动类上使用@ServletComponentScan 注解后，使用@WebServlet、@WebFilter、@WebListener标记的 Servlet、Filter、Listener 就可以自动注册到Servlet容器中，无需其他代码
//sping需要在xml中配置
@ServletComponentScan
//启动注解事务管理
@EnableTransactionManagement
//开启异步注解
@EnableAsync
//开启定时任务
@EnableScheduling
public class SpringzjApplication {

    public static void main(String[] args) {
       // 配置文件上下文
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringzjApplication.class, args);
        //从容器中获取类
        //Person person = ctx.getBean(Person.class);
       // System.out.println(person);
        String [] buff = ctx.getBeanNamesForType(Person.class);

        for (int i=0; i < buff.length; i++) {
            System.out.print(buff[i]);
        }
        System.out.println("-------------------------------------");
        //
        String [] names = ctx.getBeanDefinitionNames();
        for (String s : names) {
            System.out.println(s);
        }

        //todo 切面
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(MyAopConfig.class);

        //从容器中获取对象
       // MathJiSuan mathJiSuan = context.getBean(MathJiSuan.class);
      //  mathJiSuan.div(1,1);
        //为什么我的电脑这么卡

        //todo 1事务 2定时任务

    }



}
