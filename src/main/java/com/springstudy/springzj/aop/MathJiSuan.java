package com.springstudy.springzj.aop;

/**
 * 计算器
 */
public class MathJiSuan {
    //除法
    //aop环绕通知 修改 返回参数需修改为包装类型   int 类型无法匹配null;
    public int div (int i,int j) {
        System.out.println("计算方法");
        return i/j;
    }
}
