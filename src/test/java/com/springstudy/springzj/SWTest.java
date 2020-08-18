package com.springstudy.springzj;

import com.springstudy.springzj.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

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

        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");

        list.get(1);
        HashMap map = new HashMap(16);
        map.remove(1);

    }
}
