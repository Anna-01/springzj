package com.springstudy.springzj.controller;

import com.springstudy.springzj.pojo.Person;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    /**
     * 初始化 参数绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //设置非绑定属性
        binder.setDisallowedFields("name");
    }


    /**
     * 可以在@RequestMapping注解中用{}来表明它的变量部分，例如：
     * @return
     */
    @RequestMapping("user/{ceshi}")
    @ResponseBody
    public String testController(@PathVariable(name = "ceshi") String xx) {

            System.out.println("输出testController");
            return xx;
    }

    @RequestMapping("user")
    @ResponseBody
    public String testName(@RequestParam(value = "name") String name ) {

        System.out.println("输出testController" + name);
        return name;
    }


    @RequestMapping("user/models")
    @ResponseBody
    /*
    开启参数校验
     */
    public String testMore(@Validated  Person user ) {

        System.out.println("输出testController" + user);
        return user.getName();
    }

}
