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
        if ("lijiaxing".equals(username)) {
            user.setRole("管理员");
        }
        if ("lihua".equals(username)) {
            user.setRole("客服");
        }
        return user;
    }
}
