package com.springstudy.springzj.service;

import org.springframework.stereotype.Service;

//一般接口不用service注解
public interface MyService {
    /**
     * 添加方法
     */
    public void toAddPerson();

    /**
     * 展示输出方法   事务操作
     */
    public void showText();

    /**
     * 测试事务
     */
    public void swShow();

    public  void swAdd() throws Exception;


}
