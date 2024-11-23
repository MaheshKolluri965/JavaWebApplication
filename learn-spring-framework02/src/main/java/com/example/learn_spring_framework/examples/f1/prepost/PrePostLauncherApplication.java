package com.example.learn_spring_framework.examples.f1.prepost;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	// @PostConstruct is used on method that needs to be executed 
	// after dependency injection is done to perform any initialization
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Clean up");
	}
}

@Component
class SomeDependency {
	
	public void getReady() {
		System.out.println("some logic using somedependency");
	}
	
}

@Configuration
@ComponentScan
public class PrePostLauncherApplication {
	public static void main(String args[]) {	
		try(var context = new AnnotationConfigApplicationContext(PrePostLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
