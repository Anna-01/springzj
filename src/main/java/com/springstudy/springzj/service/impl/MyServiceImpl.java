package com.springstudy.springzj.service.impl;

import com.springstudy.springzj.dao.MyDao;
import com.springstudy.springzj.service.MyService;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "MyService")
public class MyServiceImpl implements MyService {
    @Resource
    private MyDao myDao;


    @Override
    public void toAddPerson() {
        System.out.println("myService 接口方法实现");
        myDao.add();

    }
}
