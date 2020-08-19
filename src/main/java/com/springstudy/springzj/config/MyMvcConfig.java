package com.springstudy.springzj.config;

import com.springstudy.springzj.qxlj.interceptor.AdminHandlerInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
/*    @Resource
    private AdminHandlerInterceptorAdapter adminHandlerInterceptorAdapter;*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        System.out.println("注册拦截器");
        //registry.addInterceptor(adminHandlerInterceptorAdapter).addPathPatterns("/**");
        registry.addInterceptor(new AdminHandlerInterceptorAdapter()).addPathPatterns("/authIndex");
        //.excludePathPatterns("/swagger-resources/**", "/webjars/**");
    }
}
