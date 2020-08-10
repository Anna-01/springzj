package com.springstudy.springzj;

import com.springstudy.springzj.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class SWTest {
    @Resource(name = "myService")
    private MyService myService;

    @Test
    void testSW() {
        myService.swShow();
    }
    @Test
    void testSWAdd() {
        try {
            myService.swAdd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
