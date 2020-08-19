package com.springstudy.spkz;

import com.alibaba.fastjson.JSONObject;
import com.springstudy.springzj.SpringzjApplication;
import com.springstudy.springzj.pojo.Person;
import com.springstudy.springzj.spkz.MessageEvent;
import com.springstudy.springzj.spkz.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest(classes = SpringzjApplication.class)
public class spkz {

    @Test
    public void testBeanFactory() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringzjApplication.class);
        context.refresh();
        Person person = context.getBean(Person.class);
        System.out.println(JSONObject.toJSON(person));

        //上面两行注解等于下面
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NewBaseConfig.class);
        //刷新
        //context.refresh();
        //获
    }

    @Test
    void testName() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringzjApplication.class);
        CalculateService c = (CalculateService) context.getBean("calculateService");
        //CalculateService person = (CalculateService) context.getBean(CalculateServiceImpl.class);
        //CalculateService service = (CalculateService) context.getBean("calculateService");
        //String desc = calculateService.getServiceDesc();
        System.out.println(JSONObject.toJSON(c));
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringzjApplication.class);
        applicationContext.publishEvent(new MessageEvent(new Object(),"监听器"));
        applicationContext.close();
    }
}
