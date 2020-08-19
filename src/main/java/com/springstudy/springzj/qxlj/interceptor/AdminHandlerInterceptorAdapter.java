package com.springstudy.springzj.qxlj.interceptor;

import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.qxlj.ExcludeLoginVerify;
import com.springstudy.springzj.service.OneService;
import com.springstudy.springzj.service.impl.OneServiceImpl;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author My
 */
public class AdminHandlerInterceptorAdapter implements HandlerInterceptor {

    //private AdminService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器开始执行");
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();

            ExcludeLoginVerify verifyLogin = handlerMethod.getMethodAnnotation(ExcludeLoginVerify.class);

            ExcludeLoginVerify c = clazz.getAnnotation(ExcludeLoginVerify.class);
            ExcludeLoginVerify m = method.getAnnotation(ExcludeLoginVerify.class);
            if (c ==null || m == null) {
                System.out.println("这些注解为空");
            }
            if (verifyLogin == null) {
                verifyLogin = handlerMethod.getBeanType().getAnnotation(ExcludeLoginVerify.class);
            }
            if (verifyLogin == null) {
                //没有注解 放行
                return true;
            }
            String username = request.getParameter("username");
            //有注解校验
            OneService oneService = new OneServiceImpl();
            User user = oneService.getUserInfo(username);
            if (user == null) {
                return false;
            }
            if (!"管理员".equals(user.getRole())) {
                System.out.println("该用户不是管理员不予放行");
                response.sendRedirect("/index");
                return false;
            }
            //放行
            return true;
        }
        return true;
    }


}