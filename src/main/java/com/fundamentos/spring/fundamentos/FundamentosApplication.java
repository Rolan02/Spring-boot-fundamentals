package com.fundamentos.spring.fundamentos;

import ch.qos.logback.core.spi.ComponentTracker;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthDependency;
import com.fundamentos.spring.fundamentos.bean.Mybean;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private Mybean myBean;
	private MyBeanWIthDependency myBeanWIthDependency;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean myBean, MyBeanWIthDependency myBeanWIthDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWIthDependency = myBeanWIthDependency;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWIthDependency.printWithDependency();
	}
}
