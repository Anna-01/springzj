package com.springstudy.springzj.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServlet;


public class Chinese  extends HttpServlet {
    public Chinese(String teacherName, String account) {
        this.teacherName = teacherName;
        this.account = account;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    String teacherName ;

    String account;

    /**
     * 构造函数完成后执行
     */
    @PostConstruct
    public void postCon() {
        System.out.println("构造函数执行完之后的结果");
    }
    /**
     * 对象销之前执行
     */
    @PreDestroy
    public void preDes() {
        System.out.println("对象销毁之前执行");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
