package com.fundamentos.spring.fundamentos.configuration;

import com.fundamentos.spring.fundamentos.bean.MyBeanWIthProperties;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWIthProperties function(){
        return new MyBeanWIthPropertiesImplement(name,lastName);
    }
}
