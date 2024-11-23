package com.example.learn_spring_framework.games;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// @Primary - A Bean should be given preference when multiple candidates are qualified
public class MarioGame implements GamingConsole{
	
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("go into hole");
	}
	
	public void left() {
		System.out.println("go back");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}

}
