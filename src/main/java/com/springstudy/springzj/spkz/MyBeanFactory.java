package com.springstudy.springzj.spkz;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * bean工厂后处理器
 */
//加入到容器中
@Component
public class MyBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("这时工厂的后处理器");
        //获取bean的数目
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        System.out.println("bean的数目" + count);
        //获取bean的定义名称
        String [] names = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("开始获取bean的名称");
        for (String s : names) {
            System.out.println(names);
        }
        System.out.println("结束获取bean的名称");
        //
    }
}
