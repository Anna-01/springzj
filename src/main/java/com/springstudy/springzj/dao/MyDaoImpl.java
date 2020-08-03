package com.springstudy.springzj.dao;

import org.springframework.stereotype.Repository;

/**
 *
 */
//测试1
//@Repository(value = "MyDao")
//测试2
@Repository()
public class MyDaoImpl implements MyDao{
    @Override
    public void add() {
        System.out.println("add  dao层实现类 添加");
    }

    @Override
    public void cheng() {

    }
}
