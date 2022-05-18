package com.fundamentos.spring.fundamentos.configuration;

import com.fundamentos.spring.fundamentos.bean.MyBeanWIthProperties;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthPropertiesImplement;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
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
