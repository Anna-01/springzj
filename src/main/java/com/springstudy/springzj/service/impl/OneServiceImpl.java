package com.springstudy.springzj.service.impl;

import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.service.OneService;
import org.springframework.stereotype.Service;

@Service
public class OneServiceImpl implements OneService {
    @Override
    public void showText() {

    }

    @Override
    public User getUserInfo() {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        User user = new User();
        if ("1".equals(username)) {
            user.setRole("管理员");
        }
        if ("2".equals(username)) {
            user.setRole("客服");
        }
        return user;
    }
}
