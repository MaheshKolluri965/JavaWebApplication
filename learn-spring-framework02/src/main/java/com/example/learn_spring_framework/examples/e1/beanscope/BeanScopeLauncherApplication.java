package com.example.learn_spring_framework.examples.e1.beanscope;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
// in normalclass every the spring create a singleton(same instance is retured back). 
// if you want different instance to be created each time for bean -> prototype.

// singleton - One Object instance per Spring IoC container.
// prototype - possibly many objects instances per spring IoC container
// scopes applicable only for web-aware spring ApplicationContext
		Request - one object instance per single HTTp session
		Session - one object instance per user HTTP session
		Application - One Object instance per web application runtime
		WebSOcket - One Object instance per websocket instance
	
		Java Singleton vs Spring Singleton
		Spring Singleton - One object instance per spring IoC Container
		Java Singleton - One Object instance per JVM
*/

@Component
class NormalClass {
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {
	public static void main(String args[]) {	
		try(var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
	}

}
