package com.springstudy.springzj.qxlj.aop;

import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.service.OneService;
import com.springstudy.springzj.service.impl.OneServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class LoginAop {
    @Pointcut(" execution(public * com.springstudy.springzj.qxlj.controller.RoleController.IntoAopLogin(..))")
    public void pointCut() { };

    @Before("pointCut()")
    public void auth() {
        System.out.println("aop前置通知拦截");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = request.getParameter("username");
        //有注解校验
        OneService oneService = new OneServiceImpl();
        User user = oneService.getUserInfo(username);
        if (!"管理员".equals(user.getRole())) {
            System.out.println("该用户不是管理员不予放行");
            //response.sendRedirect("/index");
        }
    }
}
