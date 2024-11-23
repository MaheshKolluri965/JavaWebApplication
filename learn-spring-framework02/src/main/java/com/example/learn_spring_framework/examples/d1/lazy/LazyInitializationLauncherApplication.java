package com.example.learn_spring_framework.examples.d1.lazy;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	private ClassA classA;
	
	public ClassB (ClassA classA) {
		System.out.println("Some intialization logic goes here");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("do something");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	public static void main(String args[]) {	
		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// when someone is using ClassB then only it will load
			System.out.println("Context init is done");
			context.getBean(ClassB.class).doSomething();	
		}
	}

}
