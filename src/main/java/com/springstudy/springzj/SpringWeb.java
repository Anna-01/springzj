package com.springstudy.springzj;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SpringWeb {

    @RequestMapping("/hello")
    @ResponseBody
    public String testHello( ) {
        return null;
    }

}
