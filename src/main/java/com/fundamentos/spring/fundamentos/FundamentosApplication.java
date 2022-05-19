package com.fundamentos.spring.fundamentos;

import ch.qos.logback.core.spi.ComponentTracker;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthDependency;
import com.fundamentos.spring.fundamentos.bean.MyBeanWIthProperties;
import com.fundamentos.spring.fundamentos.bean.Mybean;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import com.fundamentos.spring.fundamentos.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private Mybean myBean;
	private MyBeanWIthDependency myBeanWIthDependency;

	private MyBeanWIthProperties myBeanWIthProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean myBean, MyBeanWIthDependency myBeanWIthDependency, MyBeanWIthProperties myBeanWIthProperties, UserPojo userPojo,UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWIthDependency = myBeanWIthDependency;
		this.myBeanWIthProperties = myBeanWIthProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	public void run2(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWIthDependency.printWithDependency();
		System.out.println(myBeanWIthProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.debug("mi valor" + value);
		} catch (Exception e){
			LOGGER.error("Este es un error al dividir por cero " + e.getMessage());
		}

	}
	@Override
	public void run(String... args) throws Exception {
		//run();
		saveUserInDataBase();
	}
	private void getInformationJpql(){
		LOGGER.info("User con el metodo buscar email" +
				userRepository.findByUserEmail("john@gmail.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario asociado al email")));
		userRepository.findAndSort("user", Sort.by("id").descending())
		.stream().forEach(user -> LOGGER.info("Usuario con el metodo sort"));

	}

	private void saveUserInDataBase(){
		User user1 = new User("John", "john@gmail.com", LocalDate.of(2022,03,01));
		User user2 = new User("Maria", "Maria@gmail.com", LocalDate.of(2022,06,21));
		User user3 = new User("Galindo", "galindo@gmail.com", LocalDate.of(2022,10,26));
		List<User> list = Arrays.asList(user1,user2,user3);
		list.stream().forEach(userRepository::save);
	}
}
