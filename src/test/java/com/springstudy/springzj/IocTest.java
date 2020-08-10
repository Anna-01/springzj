package com.springstudy.springzj;

import com.springstudy.springzj.config.MyAopConfig;
import com.springstudy.springzj.ioc.Car;
import com.springstudy.springzj.ioc.Boss;
import com.springstudy.springzj.pojo.Chinese;
import com.springstudy.springzj.service.MyService;
import com.springstudy.springzj.service.impl.MyServiceTwoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
public class IocTest {
    //按照名称注入\
   /* @Resource装配顺序
　　1. 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
　　2. 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
　　3. 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
　　4. 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配*/
    //@Resource
    //public MyService myService;

    //@Autowired(required=false)
   // @Qualifier(value = "myServiceImpl")
    //public MyService myService;

    @Resource(type = MyService.class, name = "myServiceImpl")
    public MyService myService2;

    @Resource(name = "myServiceImpl")
    public MyService myService3;

    @Resource(type = MyService.class)
    public MyService myService4;

    @Resource
    public MyService myService5;

    /**
     * 测试依赖注入
     * @Resource 和@Autowrite
     */
    @Test
    public void testIoc() {
        //注意读取的spring上下文
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SpringzjApplication.class);
        Boss person = context.getBean(Boss.class);
        Car car = context.getBean(Car.class);
        System.out.println( person.toString() +" 和" + car);
        //myService.showText();
        context.close();
    }
    @Test
    void testAutoWtrite() {
        //myService.showText();
        //myService2.showText();
        //myService3.showText();
        //myService4.showText();
        myService5.showText();
    }
    @Test
    void testPre() {
        Chinese chinese = new Chinese("1","2");
        chinese.destroy();
    }
}
