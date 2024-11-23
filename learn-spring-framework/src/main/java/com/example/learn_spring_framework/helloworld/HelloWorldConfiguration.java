package com.example.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) { };
record Address(String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Mahesh";
	}
	
	@Bean
	public int age() {
		return 21;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Kengeri1", "Bangalore1"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
		return new Person(name, age, address2);
	}
	
	@Bean
	@Primary 
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name, age, address);
	}
	
	@Bean 
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier")Address address) {
		return new Person(name, age, address);
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Kengeri", "Bangalore");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Silkboard", "Bangalore");
	}
	
}
