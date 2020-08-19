package com.springstudy.spkz;

import com.alibaba.fastjson.JSONObject;
import com.springstudy.springzj.SpringzjApplication;
import com.springstudy.springzj.spkz.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringzjApplication.class)
public class CustomTest {

    @Resource
    public CalculateService calculateService;
    @Test
    void testName() {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringzjApplication.class);
        //CalculateService c = (CalculateService) context.getBean("calculateService");
        //CalculateService person = (CalculateService) context.getBean(CalculateServiceImpl.class);
        //CalculateService service = (CalculateService) context.getBean("calculateService");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringzjApplication.class);
        context.refresh();
         CalculateService c1 = (CalculateService) context.getBean("calculateService");
        System.out.println(c1.getServiceDesc());
        //----------------------
        String desc = calculateService.getServiceDesc();
        System.out.println(JSONObject.toJSON(desc));
    }
}
