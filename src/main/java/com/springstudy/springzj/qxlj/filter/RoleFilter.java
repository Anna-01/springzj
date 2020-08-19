package com.springstudy.springzj.qxlj.filter;

import com.springstudy.springzj.pojo.User;
import com.springstudy.springzj.service.OneService;
import com.springstudy.springzj.service.impl.OneServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * sevlet Filter过滤器 实现权限拦截
 */
@Component
public class RoleFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("roleServlet初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("doFilter开始");
        boolean isTo = false;
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return;
        }
        try {
            OneService oneService = new OneServiceImpl();
            User user = oneService.getUserInfo(username);
            if (null == user) {
                System.out.println("user为空");
            }
            if (!"管理员".equals(user.getRole())) {
                System.out.println("该用户不是管理员不予放行");
                response.sendRedirect("/index");
            } else {
                System.out.println("过滤器执行");
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println("doFilter结束");
            }

        } catch (Exception e)  {
            e.printStackTrace();
            response.sendRedirect("/index");
        }

    }

    @Override
    public void destroy() {

    }
}
