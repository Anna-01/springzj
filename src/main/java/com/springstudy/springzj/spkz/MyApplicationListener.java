package com.springstudy.springzj.spkz;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent myEvent) {
        System.out.println("监听到自定义事件。。。");
        //myEvent.printMsg(myEvent.getMessa());
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) myEvent.getApplicationContext();
        BeanDefinition beanDefinition = context.getBeanFactory().getBeanDefinition("calculateService");
        MutablePropertyValues m = beanDefinition.getPropertyValues();
        m.addPropertyValue("desc","这是监听修改的");

        System.out.println("监听展示属性的开始");
        for (PropertyValue v : m.getPropertyValueList()) {
            System.out.println(v.getName() + ":" +  v.getValue());
        }
        System.out.println("监听展示属性的结束");

    }

}
