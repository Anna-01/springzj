package com.springstudy.springzj.service;

import com.springstudy.springzj.pojo.User;

public interface OneService {
    void  showText();

    User getUserInfo();

    User getUserInfo(String username);
}
