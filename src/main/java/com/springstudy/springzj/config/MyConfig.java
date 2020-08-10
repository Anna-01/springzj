package com.springstudy.springzj.config;

import com.springstudy.springzj.pojo.Person;
import org.springframework.context.annotation.Bean;
//配置类  类似于xml

//包扫描（扫描注解·）  //如果放在这（MyConfig里 还是能够扫描到person） 因为启动时默认扫描所有
//@ComponentScan({"com.springstudy.springzj.pojo"}) // 出现  .No这样的Bean定义异常  没有扫描到

//过滤掉Controller注解
/*@ComponentScan(value = "com.springstudy",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})*/
//@Configuration
public class MyConfig {
    //向容器中注册一个bean id默认为当前方法的名称
    // 更改value值
    @Bean(value = "personxxxxxxx")
    public Person person() {
        return  new Person("lijiaixng", "20", 200, "house", true);
    }
}
