package com.example.learn_spring_framework.examples.g1.jakarta;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


// @Named is replacement for @Component
// @Inject is replacement for @Autowired in Context and dependency injection CDI

//@Component
@Named
class BusinessService {
	private DataService dataService;
	
	// @Autowired
	@Inject
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		System.out.println("setter injection");
		return dataService;
	}
}

// @Component
@Named
class DataService {
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	public static void main(String args[]) {	
		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
	}

}
