package com.springstudy.springzj.pojo;


import org.springframework.beans.factory.InitializingBean;

/**
 * @author My
 */
public class Person  implements InitializingBean {
    public Person(String name, String age, String high, String house, Boolean bl) {

        System.out.println("Person的参构造方法执行");
        this.name = name;
        this.age = age;
        this.high = high;
        this.house = house;
        this.bl = bl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }



    private String name;

    private String age;
    private String high;
    private String house;

    private Boolean bl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
