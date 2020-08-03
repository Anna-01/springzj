package com.springstudy.springzj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
//表示当前类是一个切面
@Aspect
public class LogAspects {
    //日志开始
    //在目标方法之前切入 切入时机 和切入目标


    /**
     * 切入点
     */
    @Pointcut(" execution(public int com.springstudy.springzj.aop.MathJiSuan.*(..))")
    public void pointCut() { };


    @Before("pointCut()")
    public void logBegin() {
        System.out.println("除法日志开始之前");
    }
    //日志结束
    @After("pointCut()")
    public  void logEnd() {
        System.out.println("除法日志开始之后");
    }

    //返回通知
    @AfterReturning(value = "pointCut()",returning = "result")//2.告诉spring容器result接收返回值
    //joinPoint 切入点 方法名 ，而且一定出现在参数表的第一位
    public void returnNotice(JoinPoint joinPoint ,Object result) {//1.result参数是来接受返回值
        System.out.println("除法日志返回" + result );
        System.out.println("除法日志返回" + joinPoint );

    }
    //日志异常
    @AfterThrowing("pointCut()")
    public void logException()  {
        System.out.println("除法日志异常");
    }

    //环绕通知



}
