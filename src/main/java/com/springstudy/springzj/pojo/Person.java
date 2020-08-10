package com.springstudy.springzj.pojo;

import com.sun.istack.internal.NotNull;

public class Person {
    public Person(String name, String age, String high, String house, Boolean bl) {
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


    @NotNull
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
}
