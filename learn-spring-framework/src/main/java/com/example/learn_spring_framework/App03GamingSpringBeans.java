package com.example.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learn_spring_framework.games.GameRunner;
import com.example.learn_spring_framework.games.GamingConsole;
import com.example.learn_spring_framework.games.MarioGame;
import com.example.learn_spring_framework.games.Pacman;
import com.example.learn_spring_framework.games.SuperContra;



public class App03GamingSpringBeans {
	
	public static void main(String args[]) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		
	}

}
