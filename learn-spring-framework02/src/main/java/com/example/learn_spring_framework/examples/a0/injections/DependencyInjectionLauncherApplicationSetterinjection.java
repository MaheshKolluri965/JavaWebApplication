package com.example.learn_spring_framework.examples.a0.injections;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBussinessClass1{
	
	Dependency3 dependency3;
	
	Dependency4 dependency4;
	
	// Setter based: Dependencies are set by calling setter methods on your beans.
	
	@Autowired
	public void setDependency3(Dependency3 dependency3) {
		System.out.println("Setter Injection - setDependency3");
		this.dependency3 = dependency3;
	}
	
	@Autowired
	public void setDependency4(Dependency4 dependency4) {
		System.out.println("Setter Injection - setDependency4");
		this.dependency4 = dependency4;
	}
	
	public String toString() {
		return "using " + dependency3+ "and" + dependency4; 
	}
	
}

@Component
class Dependency3 {
	
}

@Component
class Dependency4 {
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplicationSetterinjection {
	public static void main(String args[]) {
		
		try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplicationSetterinjection.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBussinessClass1.class));
		}
		
	}

}
