package com.example.learn_spring_framework.games;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraQualifier")
// @Qualifier - A Specific bean should be auto-wired(name of the bean can be used as qualifier)
public class SuperContra implements GamingConsole{

	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("sit down");
	}
	
	public void left() {
		System.out.println("go back");
	}
	
	public void right() {
		System.out.println("Shoot a bullet");
	}

}
