// Resource => https://spring.io/guides/gs/spring-boot/ for below code, it shows the beans provided by Spring Boot Framework.
// Spring Core and Spring Boot are not same, this program is the bare minimum part, for understanding Spring Boot internal concepts like beans provided etc.

package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootMain {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootMain.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
