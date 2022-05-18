package com.fundamentos.spring.fundamentos;

import ch.qos.logback.core.spi.ComponentTracker;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthDependency;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthProperties;
import com.fundamentos.spring.fundamentos.bean.Mybean;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
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

	private MyBeanWIthProperties myBeanWIthProperties;
	private UserPojo userPojo;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean myBean, MyBeanWIthDependency myBeanWIthDependency, MyBeanWIthProperties myBeanWIthProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWIthDependency = myBeanWIthDependency;
		this.myBeanWIthProperties = myBeanWIthProperties;
		this.userPojo = userPojo;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWIthDependency.printWithDependency();
		System.out.println(myBeanWIthProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
	}
}
