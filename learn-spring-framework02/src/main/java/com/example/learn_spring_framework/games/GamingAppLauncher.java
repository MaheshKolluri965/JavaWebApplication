package com.example.learn_spring_framework.games;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.core.util.SystemInfo;

class GamingConfiguration {	

}

@Configuration
@ComponentScan("com.example.learn_spring_framework.games")
public class GamingAppLauncher {
	

//	@Bean
//	public GamingConsole game() {
//		var game = new Pacman();
//		return game;
//	}
	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		System.out.println("Parameter " + game);
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}
//	
	public static void main(String args[]) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingAppLauncher.class)){
			//context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		
	}

}
