package com.example.learn_spring_framework;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.learn_spring_framework.games.GameRunner;
import com.example.learn_spring_framework.games.GamingConsole;
import com.example.learn_spring_framework.games.Pacman;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		var game = new Pacman();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	

}
