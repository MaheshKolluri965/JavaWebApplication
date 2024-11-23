package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringDatJpaRepo repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS springdatajpa", "in28Minutes"));
		repository.save(new Course(2, "Learn GCP springdatajpa", "in28Minutes"));
		repository.save(new Course(3, "Learn Azure springdatajpa", "in28Minutes"));
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println("Custom author method" + repository.findByAuthor("in28Minutes"));
		System.out.println("Custom name method" + repository.findByName("Learn AWS springdatajpa"));
		
	}

}
