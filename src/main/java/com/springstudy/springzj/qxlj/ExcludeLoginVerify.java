package com.springstudy.springzj.qxlj;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
//作用于类型和方法上
@Target({ java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD })
public @interface ExcludeLoginVerify {
     String headerName() default "on";
}
