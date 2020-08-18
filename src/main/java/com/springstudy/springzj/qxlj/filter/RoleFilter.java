package com.springstudy.springzj.qxlj.filter;

import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.service.OneService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

/**
 * sevlet Filter过滤器 实现权限拦截
 */
@Component
public class RoleFilter implements Filter {
    @Resource
    public OneService oneService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("roleServlet初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter开始");
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return;
        }
        User user = oneService.getUserInfo(username);
        if (!"管理员".equals(user.getRole())) {
            System.out.println("该用户不是管理员不予放行");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter结束");
    }

    @Override
    public void destroy() {

    }
}
