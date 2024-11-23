package com.example.learn_spring_framework.examples.a0.injections;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBussinessClass{
	
	//Filed based dependency injection - No Setter or Constructor. Dependency is injected using reflection.
	@Autowired
	Dependency1 dependency1;
	
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		return "using " + dependency1+ "and" + dependency2; 
	}
	
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplicationFieldInjection {
	public static void main(String args[]) {
		
		try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplicationFieldInjection.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBussinessClass.class));
		}
		
	}

}
