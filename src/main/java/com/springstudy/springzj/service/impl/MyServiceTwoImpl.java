package com.springstudy.springzj.service.impl;

import com.springstudy.springzj.dao.MyDao;
import com.springstudy.springzj.service.MyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service("myService")
public class MyServiceTwoImpl implements MyService {
    @Resource
    MyDao myDao;

    @Override
    public void toAddPerson() {

    }

    @Override
    public void showText() {
        System.out.println("MyServiceImpld的展示輸出方法");
    }

    @Override
    //pro xx 事务的传播行为 默认是REQUIRED 有就加入 没有就创建
    //radonly h和 insert  一起汇报异常
    //isoloation 是事务的隔离级别

    @Transactional(propagation = REQUIRED ,isolation = Isolation.READ_UNCOMMITTED)
    public void swShow() {
        myDao.cheng();
        System.out.println("插入完成");
       // int i= 10/0;
    }

    /**
     * throw 回滚了 没有插入
     * @throws Exception
     */
    @Override
    @Transactional(timeout = 1,propagation = REQUIRED ,isolation = Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public void swAdd() throws Exception {
        //myDao.swAdd();
        myDao.cheng();
        System.out.println("插入完成");
        throw new Exception();
         //int i= 10/0;
    }
}
