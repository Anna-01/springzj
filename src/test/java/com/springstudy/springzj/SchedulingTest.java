package com.springstudy.springzj;

import com.springstudy.springzj.config.SchedulingConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class SchedulingTest {


    @Test
    void testSchelduling() {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulingConfig.class);
        SchedulingConfig schedulingConfig = context.getBean(SchedulingConfig.class);
        schedulingConfig.showSchelduling();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulingConfig.class);
        SchedulingConfig schedulingConfig = context.getBean(SchedulingConfig.class);
        schedulingConfig.showSchelduling();


    }
}
