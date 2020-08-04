package com.springstudy.springzj;

import com.springstudy.springzj.aop.MathJiSuan;
import com.springstudy.springzj.config.MyAopConfig;
import com.springstudy.springzj.dao.MyDao;
import com.springstudy.springzj.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

@SpringBootTest
class SpringzjApplicationTests {

    @Resource
    private MyService myService;

    @Test
    void contextLoads() {
    }
    @Test
    void test01() {
        //注解配置上下文
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(MyAopConfig.class);

        //从容器中获取对象
        MathJiSuan mathJiSuan = context.getBean(MathJiSuan.class);
        mathJiSuan.div(1,1);
    }


    @Test
    void testService() {
        myService.toAddPerson();
    }
    /**
     * 切面相关测试
     */
    @Test
    public void testAop() {
        //todo 切面
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(MyAopConfig.class);

        //从容器中获取对象
        MathJiSuan mathJiSuan = context.getBean(MathJiSuan.class);
        mathJiSuan.div(1,1);
    }
}
