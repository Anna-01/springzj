package com.springstudy.springzj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
        System.out.println("前置通知 begin");
    }
    //日志结束
    @After("pointCut()")
    public  void logEnd() {
        System.out.println("后置通知 after");
    }

    //返回通知
    @AfterReturning(value = "pointCut()",returning = "result")//2.告诉spring容器result接收返回值//joinPoint 切入点 方法名 ，而且一定出现在参数表的第一位
    public void returnNotice(JoinPoint joinPoint ,Object result) {//1.result参数是来接受返回值 返回值时除法的运算结果
        System.out.println("除法日志  返回通知 after returning" + result );
        //System.out.println("除法日志返回" + joinPoint );

    }
    //日志异常
    @AfterThrowing("pointCut()")
    public void logException()  {
        System.out.println("除法日志异常");
    }

    //环绕通知
//
    @Around("pointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法参数值数组
       /* Object[] args = joinPoint.getArgs();
        Object result  = null;
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();
 // (Integer.class.isAssignableFrom(paramTypeArray[paramTypeArray.length - 1])
            //如果方法的参数列表最后一个参数是entityManager类型，则给其赋值
            args[args.length - 1] = 10;

            System.out.println("环绕通知1" + "args 是" + args);
            //可以实际调用切片的方法
            //如果这里不返回result，则目标对象实际返回值会被置为null
        result = joinPoint.proceed(args);

        System.out.println("环绕通知2" + "响应结果为" +result);


*/
        System.out.println("环绕通知1--");
        Object obj = joinPoint.proceed();
        System.out.println("环通知2-==");
       // return obj;
    }
}
