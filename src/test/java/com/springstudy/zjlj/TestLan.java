package com.springstudy.zjlj;

import com.alibaba.fastjson.JSONObject;
import com.springstudy.springzj.SpringzjApplication;
import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.service.OneService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = SpringzjApplication.class)
public class TestLan {
    @Resource
    public OneService oneService;
    @Test
    void testlan() {
        User u = oneService.getUserInfo("1");
        System.out.println(JSONObject.toJSON(u));
    }
}
