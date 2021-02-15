package com.swcodingschool.Lesson241;

/*
 * Here you have also defined a custom query to retrieve a list of Person
 * objects based on the lastName. You can see how to invoke it later in this
 * guide.
 *
 * @SpringBootApplication is a convenience annotation that adds all of the
 * following:
 *
 * @Configuration: Tags the class as a source of bean definitions for the
 * application context.
 *
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on
 * classpath settings, other beans, and various property settings. For example,
 * if spring-webmvc is on the classpath, this annotation flags the application
 * as a web application and activates key behaviors, such as setting up a
 * DispatcherServlet.
 *
 * @ComponentScan: Tells Spring to look for other components, configurations,
 * and services in the com/example package, letting it find the controllers.
 *
 * The main() method uses Spring Boot’s SpringApplication.run() method to launch
 * an application. Did you notice that there was not a single line of XML? There
 * is no web.xml file, either. This web application is 100% pure Java and you
 * did not have to deal with configuring any plumbing or infrastructure.
 *
 * Spring Boot automatically spins up Spring Data JPA to create a concrete
 * implementation of the PersonRepository and configure it to talk to a back end
 * in-memory database by using JPA.
 *
 * Spring Data REST builds on top of Spring MVC. It creates a collection of
 * Spring MVC controllers, JSON converters, and other beans to provide a RESTful
 * front end. These components link up to the Spring Data JPA backend. When you
 * use Spring Boot, this is all autoconfigured. If you want to investigate how
 * that works, by looking at the RepositoryRestMvcConfiguration in Spring Data
 * REST.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpawithRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpawithRestApplication.class, args);
    }

}
