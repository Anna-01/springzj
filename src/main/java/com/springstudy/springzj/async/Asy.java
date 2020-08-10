package com.springstudy.springzj.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class Asy {
    @Async
    public void  run1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("异步任务1");
    }

    @Async
    public Future<String> run3() {
        System.out.println("异步任务3带返回值");
        return new AsyncResult<>("完成") ;
    }
    public void run2() {
        System.out.println("异步任务2");
    }
}
