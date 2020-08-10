package com.springstudy.springzj.service.impl;

import com.springstudy.springzj.dao.MyDao;
import com.springstudy.springzj.service.MyService;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

///@Service(value = "MyService")
@Service
public class MyServiceImpl implements MyService {
    @Resource
    private MyDao myDao;


    @Override
    public void toAddPerson() {
        System.out.println("myService 接口方法实现");
        myDao.add();

    }

    @Override
    public void showText() {
        System.out.println("MyServiceImpl的展示輸出方法");
    }

    /**
     * 测试事务
     */
    @Override
    //@Transactional
    public void swShow() {
        myDao.cheng();
    }

    @Override
    public void swAdd() {

    }

}
