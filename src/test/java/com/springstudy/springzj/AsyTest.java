package com.springstudy.springzj;

import com.springstudy.springzj.async.Asy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
public class AsyTest {
    @Resource
    public Asy asy;

    @Test
    void testAsy() throws ExecutionException, InterruptedException {
        try {
            asy.run1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asy.run2();
        Future<String> future  = asy.run3();
        System.out.println(future.get());
    }
}
