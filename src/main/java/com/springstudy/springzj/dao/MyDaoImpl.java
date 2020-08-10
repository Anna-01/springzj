package com.springstudy.springzj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 *
 */
//测试1
//@Repository(value = "MyDao")
//测试2
@Repository
public class MyDaoImpl implements MyDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void add() {
        System.out.println("mydaoimp 的add方法");
    }

    @Override
    public void cheng() {
        String sql = "INSERT INTO `user`(username,age) VALUES(?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, username,"19");
    }

    /**
     * 事务更新
     */
    @Override
    public void swAdd() {
        String sql = "UPDATE  `user` SET age = ? where  id = ?";
       // UPDATE 'user' SET age = "1" WHERE id = 1
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, 1,1);

    }
}
