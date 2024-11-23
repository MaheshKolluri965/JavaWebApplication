package com.example.learn_spring_framework.examples.a0.injections;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBussinessClass2{
	
	Dependency5 dependency5;
	
	Dependency6 dependency6;
	
	// Constructor based: Dependencies are set by constructor on your beans.
	
	// @Autowired is not mandatory
	public YourBussinessClass2(Dependency5 dependency5, Dependency6 dependency6) {
		super();
		System.out.println("Constructor injection");
		this.dependency5 = dependency5;
		this.dependency6 = dependency6;
	}
	
	public String toString() {
		return "using " + dependency5+ "and" + dependency6; 
	}

}

@Component
class Dependency5 {
	
}

@Component
class Dependency6 {
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplicationConstructorInjection {
	public static void main(String args[]) {
		
		try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplicationConstructorInjection.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBussinessClass2.class));
		}
		
	}

}
