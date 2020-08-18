package com.springstudy.springzj.config;

import com.springstudy.springzj.qxlj.filter.RoleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    /**
     * 注册拦截器到容器中并设置 拦截参数
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean registRoleFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new RoleFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
