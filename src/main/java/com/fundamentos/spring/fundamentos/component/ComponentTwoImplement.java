package com.fundamentos.spring.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // con esta etiqueta podemos elegir que clase queremos implementar
public class ComponentTwoImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi componente 2");
    }
}
