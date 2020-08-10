package com.springstudy.springzj;

import com.springstudy.springzj.config.MyConfig;
import com.springstudy.springzj.config.NewBaseConfig;
import com.springstudy.springzj.config.ReadConfig;
import com.springstudy.springzj.pojo.Person;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@ContextConfiguration(classes = MyConfig.class)
public class ConfigTest {
    @Resource
    Person person;

    /**
     * 配置文件测试
     */
    @Test
    void testConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringzjApplication.class);
        //从配置文件获取
        ReadConfig readConfig = context.getBean(ReadConfig.class);
        readConfig.showConfigId();
        //confiationproperties
        readConfig.showAge();
    }

    /**
     * @config 注解测试
     */
    @Test
    void testConfig2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NewBaseConfig.class);
        //上面两行注解等于下面
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NewBaseConfig.class);
        //刷新
        context.refresh();
        //获取
        context.getBean(NewBaseConfig.class);
    }

    /**
     * 测试Profile
     */
    @Test
    void testProfile() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //从配置文件获取
        context.getEnvironment().setActiveProfiles();
        context.register(NewBaseConfig.class);
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("profile名字" + beanDefinitionName);
        }

    }


    @Test
    public void testContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        System.out.println(person.toString());
     /*   Person newBaseConfig = context.getBean(Person.class);
        if (newBaseConfig == null) {
            System.out.println("得不到该类");
        }
        System.out.println("改测试类名" + newBaseConfig);*/
    }
}
