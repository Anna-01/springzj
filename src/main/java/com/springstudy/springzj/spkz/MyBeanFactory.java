package com.springstudy.springzj.spkz;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * bean工厂后处理器
 */
//加入到容器中
@Component
public class MyBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
            System.out.println("开始bean工厂的后处理器");
            //获取bean的数目
            int count = configurableListableBeanFactory.getBeanDefinitionCount();
            System.out.println("bean的数目" + count);
            //获取bean的定义名称
            String [] names = configurableListableBeanFactory.getBeanDefinitionNames();
            //---------------------------------------第一種方式-----------------------------------------------
            AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) configurableListableBeanFactory.getBeanDefinition("person");
            MutablePropertyValues pv = abstractBeanDefinition.getPropertyValues();
            pv.addPropertyValue("name", "這裏是bean容器工廠");
            //设置bean属性的Scope （设置单例等）
            abstractBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

    /*        System.out.println("开始获取bean的名称");
            for (String s : names) {
                System.out.println(names);
            }
            System.out.println("结束获取bean的名称");*/
            //这种方式不要用，初始化信息提前，破坏了 spring容器的封装性
            //Person  person = configurableListableBeanFactory.getBean(Person.class);
            //person.setName("在beanFatory的后处理其中修改");
            //------------------------------------------第二种方式--------------------------------------------
          /*  BeanDefinition bdi =  configurableListableBeanFactory.getBeanDefinition("person");
            MutablePropertyValues mvs = bdi.getPropertyValues();
            PropertyValue mname = mvs.getPropertyValue("name");
            System.out.println("获取name" + JSONObject.toJSONString(mname));

            System.out.println("展示属性的开始");
            for (PropertyValue v : mvs.getPropertyValueList()) {
                System.out.println(v.getName() + ":" +  v.getValue());
            }
            System.out.println("展示属性的结束");
            mvs.addPropertyValue("name", "测试环境");*/
            //------------------------------------第三种方式------------------------------------------

          /*  //,,,,,,,,,,,,,,,,,,,
            //获取spring容器中Person的名称
            BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("person");
            String desc = bd.getDescription();
            String  className = bd.getBeanClassName();
            String fatoryName = bd.getFactoryMethodName();
            System.out.println("描述" + desc);
            System.out.println("描述" + className);
            System.out.println("描述" + fatoryName);
            //获取person的属性
            bd.getFactoryMethodName();
            MutablePropertyValues pv = bd.getPropertyValues();*/
            //展示person的属性
            System.out.println("展示属性的开始");
            for (PropertyValue v : pv.getPropertyValueList()) {
                System.out.println(v.getName() + ":" +  v.getValue());
            }
            System.out.println("展示属性的结束");

            ///修改person的属性
           // pv.addPropertyValue("name", "在beanfactory中修改那么属性");

    }
}
