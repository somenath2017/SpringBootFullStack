package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * 
 * VM Arguments -Dspring.profiles.active=test
 *
 */
/*The @SpringBootApplication annotation is equivalent to
 * using @Configuration, @EnableAutoConfiguration and @ComponentScan
 * with their default attributes:
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
