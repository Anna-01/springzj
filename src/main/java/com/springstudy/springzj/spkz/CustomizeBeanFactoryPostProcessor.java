package com.springstudy.springzj.spkz;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class CustomizeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("calculateService");
        System.out.println("beanFortory 已进入");
        MutablePropertyValues pv =  abstractBeanDefinition.getPropertyValues();

       // pv.addPropertyValue("desc", "这里是bean工厂修改改变的");
       // abstractBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
    }
}
