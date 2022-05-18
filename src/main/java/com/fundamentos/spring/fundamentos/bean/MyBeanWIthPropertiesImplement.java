package com.fundamentos.spring.fundamentos.bean;

import com.fundamentos.spring.fundamentos.bean.MyBeanWIthProperties;

public class MyBeanWIthPropertiesImplement implements MyBeanWIthProperties {
    private String name;
    private String lastName;

    public MyBeanWIthPropertiesImplement(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String function() {
        return name +"-"+ lastName;
    }
}
