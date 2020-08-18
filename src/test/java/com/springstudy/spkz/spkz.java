package com.springstudy.spkz;

import com.springstudy.springzj.SpringzjApplication;
import com.springstudy.springzj.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest(classes = SpringzjApplication.class)
public class spkz {

    @Test
    public void testBeanFactory() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();
        //Person person = context.getBean(Person.class);
        context.close();
        //上面两行注解等于下面
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NewBaseConfig.class);
        //刷新
        //context.refresh();
        //获
    }
}
