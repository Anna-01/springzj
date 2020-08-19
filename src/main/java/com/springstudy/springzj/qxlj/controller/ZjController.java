package com.springstudy.springzj.qxlj.controller;

import com.springstudy.springzj.qxlj.ExcludeLoginVerify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZjController {
    @ExcludeLoginVerify
    @RequestMapping(value = "/authIndex", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String testLogin() {
        return "这是注解拦截";
    }
}
