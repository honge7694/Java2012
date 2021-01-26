package com.example.springboot.Lesson202;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*
 * @SpringBootApplication은 다음의 세가지 애노테이션을 모두 추가하는 애노테이션이다. ( 밑에 두가지를 이 한가지로 대체함.)
 * @Configuration : 클래스를 애플리케이션 컨텍스트에 대한 Bean 정의 소스 태그로 지정한다.
 * @EnableAutoConfiguration : Spring Boot에 클래스 경로 설정, 기타 Bean 및 다양한 속성 설정을 기반으로 
 * 							 Bean추가를 시작하도록 지시하는 애노테이션.
 *							 예를 들어 spring-MVC가 클래스 경로에 있는 경우, 애플리케이션을 웹 애플리케이션으로
 *							 플래그 지정하고 DispatcherServlet 설정과 같은 주요 동작들을 활성화시킨다.
 * @ComponentScan : Spring의 com.example.springboot 패키지에서 다른 구성요소, 구성 및 서비스를
 * 					찾도록 지시하여 찾을 수 있도록 한다.
 */

@SpringBootApplication
public class Lesson202Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson202Application.class, args);
	}
	
	// Step 3. Application Class를 수정
	/*
	 * @Bean 으로 표시된 CommandLineRunner 메서드는 시작할 때 실행된다.
	 * 애플리케이션에서 생성했거나, Spring Boot에 의해 자동으로 추가된 모든 Bean을 검색하고, 정렬하여 출력한다.
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args->{
			System.out.println("Let's inspect the beans provided by Spring boot"); // Spring Boot에 의해 제공되는 Beans를 살펴보자.
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			
			for(String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
