package com.springstudy.springzj.qxlj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoleController {

    @RequestMapping("/login")
    @ResponseBody
    public String roleController() {
        System.out.println("进入controller层");
        return "您是管理员";
    }

    @RequestMapping("/index")
    public String loginPage() {
        //modelAndView.setViewName("/login");
        return "login";
    }

    /**
     * aop前置通知拦截
     */
    @RequestMapping("/aopLogin")
    public String IntoAopLogin(HttpServletRequest request) {

        aopLogin();
        return "login";
    }

    public void aopLogin() {
        System.out.println("拦截方法");
    }
}
