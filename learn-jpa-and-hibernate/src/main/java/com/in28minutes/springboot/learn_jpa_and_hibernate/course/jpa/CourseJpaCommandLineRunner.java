//package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
//
//@Component
//public class CourseJpaCommandLineRunner implements CommandLineRunner{
//
//	@Autowired
//	private CourseJpaRepo repository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert(new Course(1, "Learn AWS jpa", "in28Minutes"));
//		repository.insert(new Course(2, "Learn GCP jpa", "in28Minutes"));
//		repository.insert(new Course(3, "Learn Azure jpa", "in28Minutes"));
//		
//		repository.deleteById(2);
//		
//		System.out.println(repository.findById(3));
//	}
//
//}
