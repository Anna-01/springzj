package com.springstudy.springzj.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

     Car car;

    @Autowired
    public void setCar(Car car) {
        System.out.println("setCar执行了。。。");
        this.car = car;
    }
}
