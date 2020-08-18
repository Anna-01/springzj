package com.springstudy.springzj.qxlj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {

    @RequestMapping("/role/login")
    public void roleContro() {

        System.out.println("进入controller层");
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }
}
